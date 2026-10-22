package com.obric.cae.smartNfc;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.NfcOemExtension;
import android.nfc.NfcRoutingTableEntry;
import android.os.Binder;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.ShellCommand;
import com.obric.cae.libs.nfc.ICaeNfcAdapter;
import com.obric.cae.libs.nfc.ICaeNfcEventManager;
import com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CaeNfcAdapterService extends ICaeNfcAdapter.Stub {
    private static final String CAE_NFC_ACCESS_PERM_ERROR = "NFC_ACCESS permission required";
    private final Context mContext;
    private final CaeNfcEventManagerService mEventManagerService;
    private final CaeNfcOmapiExecutorService mOmapiExecutorService;
    private final RouteSwitchManager mRouteSwitchManager;

    /* JADX INFO: renamed from: com.obric.cae.smartNfc.CaeNfcAdapterService$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class NfcShellCommand extends ShellCommand {
        final /* synthetic */ CaeNfcAdapterService this$0;

        private NfcShellCommand(CaeNfcAdapterService r8) {
            this.this$0 = r8;
        }

        private int handleGetCplc() {
            String r8 = CaeNfcAdapterService.access$100(this.this$0).getEseIdInternal();
            PrintWriter r10 = getOutPrintWriter();
            if (r8 != null) goto L6;
            r10.println("null");
            return -1;
        L6:
            r10.println(r8);
            return 0;
        }

        private int handleListPayment() {
            if (CaeNfcAdapterService.access$200(this.this$0) != null) goto L6;
            getErrPrintWriter().println("RouteSwitchManager is null");
            return -1;
        L6:
            PrintWriter r8 = getOutPrintWriter();
            Iterator<String> r10 = CaeNfcAdapterService.access$200(this.this$0).getPaymentServiceList().iterator();
        L8:
            if (r10.hasNext() == false) goto L10;
            r8.println(r10.next());
            goto L8
        L10:
            return 0;
        }

        private int handleRouteCommand() {
            if (CaeNfcAdapterService.access$200(this.this$0) != null) goto L6;
            getErrPrintWriter().println("RouteSwitchManager is null");
            return -1;
        L6:
            String r8 = getNextArg();
            if (r8 != null) goto L11;
            return handleRouteHelp();
        L11:
            if (r8.equals("status") == true) goto L19;
            if (r8.equals("set") == true) goto L17;
            return handleRouteHelp();
        L17:
            return handleRouteSet();
        L19:
            return handleRouteStatus();
        }

        private int handleRouteHelp() {
            PrintWriter r8 = getOutPrintWriter();
            r8.println("route set <hce|ese|uicc|ndef>");
            r8.println("route status");
            return 0;
        }

        private int handleRouteSet() {
            String r8 = getNextArg();
            if (r8 != null) goto L6;
            getErrPrintWriter().println("Missing route name");
            return -1;
        L6:
            boolean r10 = CaeNfcAdapterService.access$200(this.this$0).setRouteFromShell(r8);
            PrintWriter r11 = getOutPrintWriter();
            if (r10 == false) goto L9;
            String r12 = "ok";
        L10:
            r11.println(r12);
            if (r10 == false) goto L14;
            return 0;
        L14:
            return -1;
        L9:
            r12 = "failed";
            goto L10
        }

        private int handleRouteStatus() {
            getOutPrintWriter().println(CaeNfcAdapterService.access$200(this.this$0).getRouteStatusString());
            return 0;
        }

        private int handleRoutingTable() {
            NfcAdapter r8 = NfcAdapter.getDefaultAdapter(CaeNfcAdapterService.access$300(this.this$0));
            int r10 = -1;
            if (r8 != null) goto L29;
            PrintWriter r11 = getErrPrintWriter();
            String r12 = "NfcAdapter is null";
        L5:
            r11.println(r12);
            return r10;
        L29:
            NfcOemExtension r13 = r8.getNfcOemExtension();     // Catch: Exception -> L25
            if (r13 != null) goto L27;
            r11 = getErrPrintWriter();
            r12 = "NfcOemExtension is null";
            goto L5
        L27:
            List r14 = r13.getRoutingTable();     // Catch: Exception -> L22
            r10 = 0;
            if (r14 != null) goto L14;
        L21:
            r11 = getOutPrintWriter();
            r12 = "empty";
            goto L5
        L14:
            if (r14.isEmpty() == true) goto L21;
            PrintWriter r15 = getOutPrintWriter();
            r15.println(NfcRoutingUtils.getLegend());
            Iterator r16 = r14.iterator();
            int r17 = 0;
        L18:
            if (r16.hasNext() == false) goto L20;
            r15.println(NfcRoutingUtils.formatEntry(r17, (NfcRoutingTableEntry) r16.next()));
            r17 = r17 + 1;
            goto L18
        L20:
            return 0;
        L22:
            e = e;
            r11 = getErrPrintWriter();
            StringBuilder r18 = new StringBuilder("getRoutingTable failed: ");
        L24:
            r18.append(e);
            r12 = r18.toString();
        L25:
            e = e;
            r11 = getErrPrintWriter();
            r18 = new StringBuilder("getNfcOemExtension failed: ");
            goto L24
        }

        private int handleShowPayment() {
            if (CaeNfcAdapterService.access$200(this.this$0) != null) goto L6;
            getErrPrintWriter().println("RouteSwitchManager is null");
            return -1;
        L6:
            getOutPrintWriter().println(CaeNfcAdapterService.access$200(this.this$0).getDefaultPaymentComponent());
            return 0;
        }

        public int onCommand(String r8) {
            if (r8 == null) goto L4;
            int r10 = Binder.getCallingUid();
            byte r11 = -1;
            if (r10 == 2000) goto L13;
            if (r10 == 0) goto L13;
            if (r10 == 1000) goto L13;
            getErrPrintWriter().println("Permission denied for uid=" + r10);
            return -1;
        L13:
            switch(r8.hashCode()) {
                case -586243274: goto L32;
                case 108704329: goto L28;
                case 1349535703: goto L24;
                case 1492878343: goto L20;
                case 1929996987: goto L16;
                default: goto L35;
            };
        L35:
            switch(r11) {
                case 0: goto L47;
                case 1: goto L45;
                case 2: goto L43;
                case 3: goto L41;
                case 4: goto L39;
                default: goto L37;
            };
        L37:
            return handleDefaultCommands(r8);
        L39:
            return handleGetCplc();
        L41:
            return handleRoutingTable();
        L43:
            return handleListPayment();
        L45:
            return handleRouteCommand();
        L47:
            return handleShowPayment();
        L16:
            if (r8.equals("get-cplc") == false) goto L35;
            r11 = 4;
            goto L35
        L20:
            if (r8.equals("routing-table") == false) goto L35;
            r11 = 3;
            goto L35
        L24:
            if (r8.equals("list-payment") == false) goto L35;
            r11 = 2;
            goto L35
        L28:
            if (r8.equals("route") == false) goto L35;
            r11 = 1;
            goto L35
        L32:
            if (r8.equals("show-payment") == false) goto L35;
            r11 = 0;
            goto L35
        L4:
            return handleDefaultCommands(r8);
        }

        public void onHelp() {
            PrintWriter r8 = getOutPrintWriter();
            r8.println("CAE NFC adapter commands:");
            r8.println("  get-cplc");
            r8.println("    Get CPLC from eSE.");
            r8.println("  route set <hce|ese|uicc|ndef>");
            r8.println("    Set default route by NfcOemExtension.");
            r8.println("  route status");
            r8.println("    Show current route status and settings.");
            r8.println("  show-payment");
            r8.println("    Show current default payment component.");
            r8.println("  list-payment");
            r8.println("    List registered payment services.");
            r8.println("  routing-table");
            r8.println("    Dump current NFC routing table.");
        }

        public /* synthetic */ NfcShellCommand(CaeNfcAdapterService r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public CaeNfcAdapterService(Context r8, CaeNfcOmapiExecutorService r10, CaeNfcEventManagerService r11, RouteSwitchManager r12) {
        this.mContext = r8;
        this.mOmapiExecutorService = r10;
        this.mEventManagerService = r11;
        this.mRouteSwitchManager = r12;
    }

    public static /* synthetic */ CaeNfcOmapiExecutorService access$100(CaeNfcAdapterService r8) {
        return r8.mOmapiExecutorService;
    }

    public static /* synthetic */ RouteSwitchManager access$200(CaeNfcAdapterService r8) {
        return r8.mRouteSwitchManager;
    }

    public static /* synthetic */ Context access$300(CaeNfcAdapterService r8) {
        return r8.mContext;
    }

    private void enforceAccessPermission() {
        this.mContext.enforceCallingOrSelfPermission(NfcConstants.CAE_NFC_ACCESS_PERM, CAE_NFC_ACCESS_PERM_ERROR);
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
    public ICaeNfcEventManager getEventManager() {
        enforceAccessPermission();
        return this.mEventManagerService;
    }

    @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
    public ICaeNfcOmapiExecutor getOmapiExecutor() {
        enforceAccessPermission();
        return this.mOmapiExecutorService;
    }

    public void onShellCommand(FileDescriptor r10, FileDescriptor r11, FileDescriptor r12, String[] r13, ShellCallback r14, ResultReceiver r15) {
        new NfcShellCommand(this, null).exec(this, r10, r11, r12, r13, r14, r15);
    }
}
