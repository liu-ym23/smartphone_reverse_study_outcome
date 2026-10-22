package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String SWITCH_PREFIX = "--";
    private static final String SWITCH_TERMINATOR = "--";
    private static final String SWITCH_VALUE_SEPARATOR = "=";
    private static final String TAG = "CommandLine";
    private static final AtomicReference<CommandLine> sCommandLine = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.CommandLine$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class JavaCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<String> mArgs;
        private int mArgsBegin;
        private HashMap<String, String> mSwitches;

        public JavaCommandLine(String[] r8) {
            super(null);
            this.mSwitches = new HashMap();
            ArrayList<String> r10 = new ArrayList();
            this.mArgs = r10;
            this.mArgsBegin = 1;
            if (r8 != null) goto L5;
        L10:
            r10.add("");
            return;
        L5:
            if (r8.length == 0) goto L10;
            String r11 = r8[0];
            if (r11 == null) goto L10;
            r10.add(r11);
            appendSwitchesInternal(r8, 1);
        }

        private void appendSwitchesInternal(String[] r10, int r11) {
            int r8 = r10.length;
            boolean r12 = true;
            int r13 = 0;
        L3:
            if (r13 >= r8) goto L20;
            String r14 = r10[r13];
            if (r11 <= 0) goto L8;
            r11 = r11 - 1;
        L19:
            r13 = r13 + 1;
            goto L3
        L8:
            if (r14.equals("--") == false) goto L10;
            r12 = false;
        L10:
            if (r12 == true) goto L12;
        L18:
            this.mArgs.add(r14);
            goto L19
        L12:
            if (r14.startsWith("--") == false) goto L18;
            String[] r15 = r14.split(CommandLine.SWITCH_VALUE_SEPARATOR, 2);
            if (r15.length <= 1) goto L16;
            String r16 = r15[1];
        L17:
            appendSwitchWithValue(r15[0].substring(2), r16);
            goto L19
        L16:
            r16 = null;
            goto L17
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitch(String r8) {
            appendSwitchWithValue(r8, null);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchWithValue(String r8, String r10) {
            HashMap<String, String> r11 = this.mSwitches;
            if (r10 != null) goto L5;
            String r12 = "";
        L6:
            r11.put(r8, r12);
            String r13 = "--" + r8;
            if (r10 != null) goto L9;
        L11:
            ArrayList<String> r14 = this.mArgs;
            int r15 = this.mArgsBegin;
            this.mArgsBegin = r15 + 1;
            r14.add(r15, r13);
            return;
        L9:
            if (r10.isEmpty() == true) goto L11;
            r13 = defpackage.a.f(r13, CommandLine.SWITCH_VALUE_SEPARATOR, r10);
            goto L11
        L5:
            r12 = r10;
            goto L6
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] r8) {
            appendSwitchesInternal(r8, 0);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String[] getCommandLineArguments() {
            ArrayList<String> r8 = this.mArgs;
            return (String[]) r8.toArray(new String[r8.size()]);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String getSwitchValue(String r8) {
            String r10 = this.mSwitches.get(r8);
            if (r10 != null) goto L5;
        L6:
            return null;
        L5:
            if (r10.isEmpty() == true) goto L6;
            return r10;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean hasSwitch(String r8) {
            return this.mSwitches.containsKey(r8);
        }
    }

    public static class NativeCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public NativeCommandLine(String[] r8) {
            super(null);
            CommandLine.access$100(r8);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitch(String r8) {
            CommandLine.access$400(r8);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchWithValue(String r8, String r10) {
            CommandLine.access$500(r8, r10);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] r8) {
            CommandLine.access$600(r8);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void destroy() {
            throw new IllegalStateException("Can't destroy native command line after startup");
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String[] getCommandLineArguments() {
            return null;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String getSwitchValue(String r8) {
            return CommandLine.access$300(r8);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean hasSwitch(String r8) {
            return CommandLine.access$200(r8);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean isNativeImplementation() {
            return true;
        }
    }

    static {
        sCommandLine = new AtomicReference();
    }

    private CommandLine() {
    }

    public /* synthetic */ CommandLine(AnonymousClass1 r8) {
        this();
    }

    public static /* synthetic */ void access$100(String[] r8) {
        nativeInit(r8);
    }

    public static /* synthetic */ boolean access$200(String r8) {
        return nativeHasSwitch(r8);
    }

    public static /* synthetic */ String access$300(String r8) {
        return nativeGetSwitchValue(r8);
    }

    public static /* synthetic */ void access$400(String r8) {
        nativeAppendSwitch(r8);
    }

    public static /* synthetic */ void access$500(String r8, String r10) {
        nativeAppendSwitchWithValue(r8, r10);
    }

    public static /* synthetic */ void access$600(String[] r8) {
        nativeAppendSwitchesAndArguments(r8);
    }

    public static void enableNativeProxy() {
        sCommandLine.set(new NativeCommandLine(getJavaSwitchesOrNull()));
    }

    @VisibleForTesting
    public static CommandLine getInstance() {
        return sCommandLine.get();
    }

    public static String[] getJavaSwitchesOrNull() {
        CommandLine r8 = sCommandLine.get();
        if (r8 != null) goto L5;
        return null;
    L5:
        return r8.getCommandLineArguments();
    }

    public static void init(String[] r8) {
        setInstance(new JavaCommandLine(r8));
    }

    public static void initFromFile(String r8) {
        char[] r10 = readFileAsUtf8(r8);
        if (r10 != null) goto L5;
        String[] r11 = null;
    L6:
        init(r11);
        return;
    L5:
        r11 = tokenizeQuotedArguments(r10);
        goto L6
    }

    public static boolean isInitialized() {
        if (sCommandLine.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static native void nativeAppendSwitch(String r8);

    private static native void nativeAppendSwitchWithValue(String r8, String r10);

    private static native void nativeAppendSwitchesAndArguments(String[] r8);

    private static native String nativeGetSwitchValue(String r8);

    private static native boolean nativeHasSwitch(String r8);

    private static native void nativeInit(String[] r8);

    private static char[] readFileAsUtf8(String r8) {
        File r10 = new File(r8);
        FileReader r11 = new FileReader(r10);     // Catch: IOException -> L15
        char[] r12 = new char[(int) r10.length()];     // Catch: Throwable -> L7
        char[] r13 = Arrays.copyOfRange(r12, 0, r11.read(r12));     // Catch: Throwable -> L7
        r11.close();     // Catch: IOException -> L15
        return r13;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: IOException -> L15
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L15
    L15:
        return null;
    }

    @VisibleForTesting
    public static void reset() {
        setInstance(null);
    }

    private static void setInstance(CommandLine r8) {
        CommandLine r10 = sCommandLine.getAndSet(r8);
        if (r10 == null) goto L6;
        r10.destroy();
        return;
    }

    @VisibleForTesting
    public static String[] tokenizeQuotedArguments(char[] r10) {
        if (r10.length > 65536) goto L38;
        ArrayList r8 = new ArrayList();
        int r11 = r10.length;
        StringBuilder r12 = null;
        int r13 = 0;
        char r14 = 0;
    L5:
        if (r13 >= r11) goto L31;
        char r15 = r10[r13];
        if (r14 == 0) goto L9;
    L12:
        if (r15 != r14) goto L22;
    L13:
        if (r12 != null) goto L15;
    L19:
        if (r14 != 0) goto L21;
        r14 = r15;
    L30:
        r13 = r13 + 1;
        goto L5
    L21:
        r14 = 0;
        goto L30
    L15:
        if (r12.length() <= 0) goto L19;
        if (r12.charAt(r12.length() - 1) != '\\') goto L19;
        r12.setCharAt(r12.length() - 1, r15);
        goto L30
    L22:
        if (r14 == 0) goto L24;
    L27:
        if (r12 != null) goto L29;
        r12 = new StringBuilder();
    L29:
        r12.append(r15);
        goto L30
    L24:
        if (Character.isWhitespace(r15) == false) goto L27;
        if (r12 == null) goto L30;
        r8.add(r12.toString());
        r12 = null;
        goto L30
    L9:
        if (r15 == '\'') goto L13;
        if (r15 == '\"') goto L13;
    L31:
        if (r12 == null) goto L36;
        if (r14 == 0) goto L34;
        android.util.Log.w(TAG, "Unterminated quoted string: " + r12);
    L34:
        r8.add(r12.toString());
    L36:
        return (String[]) r8.toArray(new String[r8.size()]);
    L38:
        throw new RuntimeException("Flags file too big: " + r10.length);
    }

    @VisibleForTesting
    public abstract void appendSwitch(String r8);

    public abstract void appendSwitchWithValue(String r8, String r10);

    public abstract void appendSwitchesAndArguments(String[] r8);

    public void destroy() {
    }

    public abstract String[] getCommandLineArguments();

    public abstract String getSwitchValue(String r8);

    public String getSwitchValue(String r8, String r10) {
        String r11 = getSwitchValue(r8);
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r10;
    L6:
        return r11;
    }

    @VisibleForTesting
    public abstract boolean hasSwitch(String r8);

    public boolean isNativeImplementation() {
        return false;
    }
}
