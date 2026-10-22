package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@MainDex
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String SWITCH_PREFIX = "--";
    private static final String SWITCH_TERMINATOR = "--";
    private static final String SWITCH_VALUE_SEPARATOR = "=";
    private static final String TAG = "CommandLine";
    private static final AtomicReference<CommandLine> sCommandLine = null;

    private CommandLine() {
    }

    public static void reset() {
        setInstance(null);
    }

    public abstract void appendSwitch(String r1);

    public abstract void appendSwitchWithValue(String r1, String r2);

    public abstract void appendSwitchesAndArguments(String[] r1);

    public void destroy() {
    }

    public abstract String[] getCommandLineArguments();

    public abstract String getSwitchValue(String r1);

    public abstract Map getSwitches();

    public abstract boolean hasSwitch(String r1);

    public boolean isNativeImplementation() {
        return false;
    }

    public abstract void removeSwitch(String r1);

    static {
        sCommandLine = new AtomicReference();
    }

    public static void enableNativeProxy() {
        sCommandLine.set(new NativeCommandLine(getJavaSwitchesOrNull()));
    }

    public static CommandLine getInstance() {
        return sCommandLine.get();
    }

    public static String[] getJavaSwitchesOrNull() {
        CommandLine r0 = sCommandLine.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCommandLineArguments();
    }

    public static boolean isInitialized() {
        if (sCommandLine.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ CommandLine(1 r1) {
        this();
    }

    public static void init(String[] r1) {
        setInstance(new JavaCommandLine(r1));
    }

    public static void initFromFile(String r0) {
        char[] r1 = readFileAsUtf8(r0);
        if (r1 != null) goto L5;
        String[] r2 = null;
    L6:
        init(r2);
        return;
    L5:
        r2 = tokenizeQuotedArguments(r1);
        goto L6
    }

    private static char[] readFileAsUtf8(String r3) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        PolarisFileReaderWrapper r4 = new PolarisFileReaderWrapper(r0);     // Catch: IOException -> L13
        char[] r1 = new char[(int) r0.length()];     // Catch: Throwable -> L7
        char[] r2 = Arrays.copyOfRange(r1, 0, r4.read(r1));     // Catch: Throwable -> L7
        r4.close();     // Catch: IOException -> L13
        return r2;
    L7:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L13
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L13
    L13:
        return null;
    }

    private static void setInstance(CommandLine r1) {
        CommandLine r2 = sCommandLine.getAndSet(r1);
        if (r2 == null) goto L6;
        r2.destroy();
        return;
    }

    public static void setInstanceForTesting(CommandLine r0) {
        setInstance(r0);
    }

    public static String[] tokenizeQuotedArguments(char[] r10) {
        if (r10.length > 65536) goto L38;
        ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        StringBuilder r5 = null;
        int r4 = 0;
        char r6 = 0;
    L5:
        if (r4 >= r1) goto L31;
        char r7 = r10[r4];
        if (r6 == 0) goto L9;
    L12:
        if (r7 != r6) goto L22;
    L13:
        if (r5 != null) goto L15;
    L19:
        if (r6 != 0) goto L21;
        r6 = r7;
    L30:
        r4 = r4 + 1;
        goto L5
    L21:
        r6 = 0;
        goto L30
    L15:
        if (r5.length() <= 0) goto L19;
        if (r5.charAt(r5.length() - 1) != '\\') goto L19;
        r5.setCharAt(r5.length() - 1, r7);
        goto L30
    L22:
        if (r6 == 0) goto L24;
    L27:
        if (r5 != null) goto L29;
        r5 = new StringBuilder();
    L29:
        r5.append(r7);
        goto L30
    L24:
        if (Character.isWhitespace(r7) == false) goto L27;
        if (r5 == null) goto L30;
        r0.add(r5.toString());
        r5 = null;
        goto L30
    L9:
        if (r7 == '\'') goto L13;
        if (r7 == '\"') goto L13;
    L31:
        if (r5 == null) goto L36;
        if (r6 != 0) goto L34;
    L34:
        r0.add(r5.toString());
    L36:
        return (String[]) r0.toArray(new String[r0.size()]);
    L38:
        throw new RuntimeException("Flags file too big: " + r10.length);
    }

    public String getSwitchValue(String r2, String r3) {
        String r4 = getSwitchValue(r2);
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return r3;
    L6:
        return r4;
    }
}
