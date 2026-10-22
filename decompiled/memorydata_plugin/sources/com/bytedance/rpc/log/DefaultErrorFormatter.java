package com.bytedance.rpc.log;

import android.app.Application;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultErrorFormatter implements ErrorFormatter {
    private static final IReportFilter DEFAULT_FILTER = null;
    private static DefaultErrorFormatter sDefaultErrorFormat;
    private boolean mCheckActivityName;
    private boolean mEnsureMaxStackCount;
    private boolean mEnsurePackageStackCount;
    private String[] mExtraPackages;
    private TreeSet<String> mImpossiblePackages;
    private int mMaxStackCount;
    private int mMinPackageStackCount;
    private boolean mShowLineNumber;
    private IReportFilter mStackFilter;
    private int mSuggestStackCount;

    public interface IReportFilter {
        boolean acceptReportStack(String r1, String r2);

        String formatReportStack(String r1, Throwable r2, List<StackTraceElement> r3, boolean r4);
    }

    static {
        DEFAULT_FILTER = new AnonymousClass1();
    }

    public DefaultErrorFormatter(int r3, int r4, int r5, String... r6) {
        this.mImpossiblePackages = null;
        this.mExtraPackages = null;
        this.mStackFilter = null;
        this.mShowLineNumber = true;
        this.mEnsurePackageStackCount = true;
        this.mEnsureMaxStackCount = true;
        this.mCheckActivityName = true;
        this.mMaxStackCount = -1;
        this.mMinPackageStackCount = -1;
        this.mSuggestStackCount = -1;
        this.mSuggestStackCount = r3;
        this.mMaxStackCount = r4;
        this.mMinPackageStackCount = r5;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length <= 1) goto L9;
        setExtraPackages(r6);
        return;
    }

    public static DefaultErrorFormatter get() {
        if (sDefaultErrorFormat != null) goto L15;
        monitor-enter(DefaultErrorFormatter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sDefaultErrorFormat != null) goto L9;
        sDefaultErrorFormat = new DefaultErrorFormatter(6, 18, 3, new String[0]);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DefaultErrorFormatter.class);     // Catch: Throwable -> L11
    L15:
        return sDefaultErrorFormat;
    }

    public static HashSet<String> getAllImpossiblePackage(Context r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        HashSet<String> r0 = new HashSet();
        if (r9 != null) goto L30;
    L29:
        return r0;
    L30:
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();     // Catch: PackageManager.NameNotFoundException -> L27
        if (RpcUtils.isVisible(r2) == false) goto L29;
        r0.add(r2);     // Catch: PackageManager.NameNotFoundException -> L27
        ActivityInfo[] r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r2, 15).activities;     // Catch: PackageManager.NameNotFoundException -> L27
        if (r10 == null) goto L29;
        if (r10.length <= 0) goto L29;
        int r1 = r10.length;     // Catch: PackageManager.NameNotFoundException -> L27
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L29;
        ActivityInfo r4 = r10[r3];     // Catch: PackageManager.NameNotFoundException -> L27
        if (r4 == null) goto L26;
        if (RpcUtils.isVisible(r4.packageName) == false) goto L26;
        r0.add(r4.packageName);     // Catch: PackageManager.NameNotFoundException -> L27
        if (r8 == false) goto L26;
        String r5 = r4.name;     // Catch: PackageManager.NameNotFoundException -> L27
        if (r5 != null) goto L21;
        int r6 = -1;
    L22:
        if (r6 <= 0) goto L26;
        String r11 = r5.substring(0, r6);     // Catch: PackageManager.NameNotFoundException -> L27
        int r12 = r11.lastIndexOf(46);     // Catch: PackageManager.NameNotFoundException -> L27
        if (r12 <= 0) goto L26;
        r0.add(r11.substring(0, r12));     // Catch: PackageManager.NameNotFoundException -> L27
        goto L26
    L21:
        r6 = r5.lastIndexOf(46);     // Catch: PackageManager.NameNotFoundException -> L27
    L26:
        r3 = r3 + 1;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    public static Throwable getLastCause(Throwable r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.getCause() == null) goto L9;
        r1 = r1.getCause();
        goto L4
    L9:
        return r1;
    }

    @Override // com.bytedance.rpc.log.ErrorFormatter
    public String formatError(String r8, Throwable r9) {
        Throwable r0 = getLastCause(r9);
        if (r0 == null) goto L18;
        StackTraceElement[] r1 = r0.getStackTrace();
        List<StackTraceElement> r2 = Collections.emptyList();
        IReportFilter r3 = this.mStackFilter;
        if (r3 != null) goto L7;
        r3 = DEFAULT_FILTER;
    L7:
        if (r1 != null) goto L9;
    L15:
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        String r7 = r3.formatReportStack(r8, r9, r2, this.mShowLineNumber);
    L19:
        if (r7 != null) goto L22;
        return "";
    L22:
        return r7;
    L9:
        if (r1.length <= 0) goto L15;
        r2 = getBestStackTraceElement(r1, r3);
        if (r2.size() != 0) goto L13;
    L14:
        r2.add(0, r1[0]);
        goto L15
    L13:
        if (r2.get(0) == r1[0]) goto L15;
    L18:
        r7 = null;
        goto L19
    }

    public List<StackTraceElement> getBestStackTraceElement(StackTraceElement[] r18, IReportFilter r19) {
        IReportFilter r2 = (IReportFilter) ZeusTransformUtils.wrapperContextForParams(r19, IReportFilter.class, "com.obric.memorydata.plugin");
        int r4 = r18.length;
        int[] r5 = getStackRangeOption(r4);
        int r7 = r5[0];
        int r9 = r5[1];
        int r6 = r5[2];
        ArrayList r10 = new ArrayList(r9 + 1);
        int r11 = 0;
    L3:
        if (r11 >= r4) goto L26;
        StackTraceElement r12 = r18[r11];
        String r13 = r12.getClassName();
        String r14 = r12.getMethodName();
        if (RpcUtils.isVisible(r13) == false) goto L24;
        if (RpcUtils.isVisible(r14) == false) goto L24;
        if (r11 == 0) goto L12;
        if (r2 == null) goto L12;
        if (r2.acceptReportStack(r13, r14) == false) goto L24;
    L12:
        r9 = r9 - 1;
        r7 = r7 - 1;
        r10.add(r12);
        if (r6 <= 0) goto L20;
        Iterator<String> r15 = getImpossiblePackages().iterator();
    L16:
        if (r15.hasNext() == false) goto L20;
        if (r13.startsWith((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L16;
        r6 = r6 - 1;
    L20:
        if (r6 > 0) goto L22;
        if (r9 <= 0) goto L26;
    L22:
        if (r7 <= 0) goto L26;
    L24:
        r11 = r11 + 1;
    L26:
        if (this.mEnsurePackageStackCount == false) goto L79;
        if (r6 > 0) goto L29;
        return r10;
    L29:
        if (r11 >= (r4 - 1)) goto L81;
        ArrayList r8 = new ArrayList(r4 - r11);
        int r16 = r11 + 1;
        int r17 = -1;
    L31:
        if (r16 >= r4) goto L49;
        StackTraceElement r110 = r18[r16];
        String r111 = r110.getClassName();
        String r112 = r110.getMethodName();
        if (RpcUtils.isVisible(r111) == false) goto L48;
        if (RpcUtils.isVisible(r112) == false) goto L48;
        if (r2 != null) goto L38;
    L39:
        r8.add(r110);
        Iterator<String> r113 = getImpossiblePackages().iterator();
    L41:
        if (r113.hasNext() == false) goto L46;
        if (r111.startsWith((String) ZeusTransformUtils.preCheckCast(r113.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L41;
        r6 = r6 - 1;
        r17 = r8.size();
        goto L41
    L46:
        if (r6 > 0) goto L48;
    L38:
        if (r2.acceptReportStack(r111, r112) == true) goto L39;
    L48:
        r16 = r16 + 1;
    L49:
        if (r17 == (-1)) goto L82;
        int r1 = r10.size();
        r10.addAll(r8.subList(0, r17));
        if (this.mEnsureMaxStackCount == false) goto L83;
        int r0 = r10.size();
        int r3 = (r10.size() - r1) + 1;
        if (r3 > 0) goto L55;
        return r10;
    L55:
        if (r3 < r10.size()) goto L57;
        return r10;
    L57:
        return r10.subList(r3, r0);
    L83:
        return r10;
    L82:
        return r10;
    L81:
        return r10;
    L79:
        return r10;
    }

    public String getDescription(Throwable r2) {
        Thread r0 = Thread.currentThread();
        if (r0 != null) goto L5;
        String r1 = null;
    L7:
        return formatError(r1, r2);
    L5:
        r1 = r0.getName();
        goto L7
    }

    public TreeSet<String> getImpossiblePackages() {
        if (this.mImpossiblePackages != null) goto L32;
        HashSet<String> r0 = getAllImpossiblePackage((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(RpcService.getRpcContext().getApplicationContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), this.mCheckActivityName);
        String[] r2 = this.mExtraPackages;
        if (r2 != null) goto L7;
    L14:
        this.mImpossiblePackages = new TreeSet();
        Iterator<String> r1 = r0.iterator();
    L16:
        if (r1.hasNext() == false) goto L32;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mImpossiblePackages.isEmpty() == true) goto L28;
        Iterator<String> r4 = this.mImpossiblePackages.iterator();
    L21:
        if (r4.hasNext() == false) goto L28;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.startsWith(r5) == true) goto L24;
        if (r5.startsWith(r3) == false) goto L21;
        r4.remove();
        goto L21
    L24:
        boolean r6 = false;
    L29:
        if (r6 == false) goto L16;
        this.mImpossiblePackages.add(r3);
    L28:
        r6 = true;
        goto L29
    L7:
        if (r2.length <= 0) goto L14;
        int r7 = r2.length;
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L14;
        String r9 = r2[r8];
        if (RpcUtils.isVisible(r9) == false) goto L13;
        r0.add(r9);
    L13:
        r8 = r8 + 1;
    L32:
        return this.mImpossiblePackages;
    }

    public int[] getStackRangeOption(int r4) {
        int[] r0 = new int[3];
        int r1 = this.mMaxStackCount;
        if (r1 > 0) goto L5;
        r0[0] = r4;
    L6:
        int r5 = this.mSuggestStackCount;
        if (r5 > 0) goto L9;
        r0[1] = Math.min(r0[0], 5);
    L10:
        int r3 = this.mMinPackageStackCount;
        if (r3 >= 0) goto L13;
        r0[2] = Math.min(r0[1], 1);
    L14:
        return r0;
    L13:
        r0[2] = Math.min(r0[1], r3);
        goto L14
    L9:
        r0[1] = Math.min(r0[0], r5);
        goto L10
    L5:
        r0[0] = Math.min(r1, r4);
        goto L6
    }

    public DefaultErrorFormatter setExtraPackages(String... r1) {
        this.mExtraPackages = r1;
        TreeSet<String> r2 = this.mImpossiblePackages;
        if (r2 == null) goto L5;
        r2.clear();
        this.mImpossiblePackages = null;
    L5:
        return this;
    }

    public DefaultErrorFormatter setMaxStackCount(int r1) {
        this.mMaxStackCount = r1;
        return this;
    }

    public DefaultErrorFormatter setMinPackageStackCount(int r1) {
        this.mMinPackageStackCount = r1;
        return this;
    }

    public DefaultErrorFormatter setShowLineNumber(boolean r1) {
        this.mShowLineNumber = r1;
        return this;
    }

    public DefaultErrorFormatter setStackCountConstraint(boolean r1, boolean r2, boolean r3) {
        this.mCheckActivityName = r1;
        this.mEnsurePackageStackCount = r2;
        this.mEnsureMaxStackCount = r3;
        return this;
    }

    public DefaultErrorFormatter setStackFilter(IReportFilter r3) {
        this.mStackFilter = (IReportFilter) ZeusTransformUtils.wrapperContextForParams(r3, IReportFilter.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DefaultErrorFormatter setSuggestStackCount(int r1) {
        this.mSuggestStackCount = r1;
        return this;
    }
}
