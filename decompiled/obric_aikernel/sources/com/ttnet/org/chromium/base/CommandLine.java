package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class JavaCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<String> mArgs;
        private int mArgsBegin;
        private HashMap<String, String> mSwitches;

        static {
        }

        JavaCommandLine(@Nullable String[] r10) {
            super(null);
            this.mSwitches = new HashMap();
            ArrayList<String> r11 = new ArrayList();
            this.mArgs = r11;
            this.mArgsBegin = 1;
            if (r10 != null) goto L5;
        L10:
            r11.add("");
            return;
        L5:
            if (r10.length == 0) goto L10;
            if (r10[0] == null) goto L10;
            r11.add(r10[0]);
            appendSwitchesInternal(r10, 1);
        }

        private void appendSwitchesInternal(String[] r10, int r11) {
            int r12 = r10.length;
            int r13 = 0;
            boolean r14 = true;
        L3:
            if (r13 >= r12) goto L20;
            String r15 = r10[r13];
            if (r11 <= 0) goto L8;
            r11 = r11 - 1;
        L19:
            r13 = r13 + 1;
            goto L3
        L8:
            if (r15.equals("--") == false) goto L10;
            r14 = false;
        L10:
            if (r14 == true) goto L12;
        L18:
            this.mArgs.add(r15);
            goto L19
        L12:
            if (r15.startsWith("--") == false) goto L18;
            String[] r16 = r15.split(CommandLine.SWITCH_VALUE_SEPARATOR, 2);
            if (r16.length <= 1) goto L16;
            String r17 = r16[1];
        L17:
            appendSwitchWithValue(r16[0].substring(2), r17);
            goto L19
        L16:
            r17 = null;
            goto L17
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitch(String r10) {
            appendSwitchWithValue(r10, null);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchWithValue(String r10, String r11) {
            HashMap<String, String> r12 = this.mSwitches;
            if (r11 != null) goto L5;
            String r13 = "";
        L6:
            r12.put(r10, r13);
            String r14 = "--" + r10;
            if (r11 != null) goto L9;
        L11:
            ArrayList<String> r15 = this.mArgs;
            int r16 = this.mArgsBegin;
            this.mArgsBegin = r16 + 1;
            r15.add(r16, r14);
            return;
        L9:
            if (r11.isEmpty() == true) goto L11;
            r14 = r14 + CommandLine.SWITCH_VALUE_SEPARATOR + r11;
            goto L11
        L5:
            r13 = r11;
            goto L6
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] r10) {
            appendSwitchesInternal(r10, 0);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        protected String[] getCommandLineArguments() {
            ArrayList<String> r10 = this.mArgs;
            return (String[]) r10.toArray(new String[r10.size()]);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String getSwitchValue(String r10) {
            String r11 = this.mSwitches.get(r10);
            if (r11 != null) goto L5;
        L6:
            return null;
        L5:
            if (r11.isEmpty() == true) goto L6;
            return r11;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public Map<String, String> getSwitches() {
            return new HashMap(this.mSwitches);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean hasSwitch(String r10) {
            return this.mSwitches.containsKey(r10);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void removeSwitch(String r10) {
            this.mSwitches.remove(r10);
            String r11 = "--" + r10;
            int r12 = this.mArgsBegin - 1;
        L3:
            if (r12 <= 0) goto L10;
            if (this.mArgs.get(r12).equals(r11) == false) goto L7;
        L8:
            this.mArgsBegin--;
            this.mArgs.remove(r12);
        L9:
            r12 = r12 - 1;
            goto L3
        L7:
            if (this.mArgs.get(r12).startsWith(r11 + CommandLine.SWITCH_VALUE_SEPARATOR) == false) goto L9;
        }
    }

    private static class NativeCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
        }

        public NativeCommandLine(@Nullable String[] r10) {
            super(null);
            CommandLineJni.get().init(r10);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitch(String r10) {
            CommandLineJni.get().appendSwitch(r10);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchWithValue(String r10, String r11) {
            Natives r12 = CommandLineJni.get();
            if (r11 != null) goto L5;
            r11 = "";
        L5:
            r12.appendSwitchWithValue(r10, r11);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] r10) {
            CommandLineJni.get().appendSwitchesAndArguments(r10);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        protected void destroy() {
            throw new IllegalStateException("Can't destroy native command line after startup");
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        protected String[] getCommandLineArguments() {
            return null;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String getSwitchValue(String r10) {
            return CommandLineJni.get().getSwitchValue(r10);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public Map<String, String> getSwitches() {
            HashMap r10 = new HashMap();
            String[] r11 = CommandLineJni.get().getSwitchesFlattened();
            int r12 = 0;
        L4:
            if (r12 >= r11.length) goto L6;
            r10.put(r11[r12], r11[r12 + 1]);
            r12 = r12 + 2;
            goto L4
        L6:
            return r10;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean hasSwitch(String r10) {
            return CommandLineJni.get().hasSwitch(r10);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean isNativeImplementation() {
            return true;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void removeSwitch(String r10) {
            CommandLineJni.get().removeSwitch(r10);
        }
    }

    interface Natives {
        void appendSwitch(String r10);

        void appendSwitchWithValue(String r10, String r11);

        void appendSwitchesAndArguments(String[] r10);

        String getSwitchValue(String r10);

        String[] getSwitchesFlattened();

        boolean hasSwitch(String r10);

        void init(String[] r10);

        void removeSwitch(String r10);
    }

    static {
        sCommandLine = new AtomicReference();
    }

    private CommandLine() {
    }

    /* synthetic */ CommandLine(AnonymousClass1 r10) {
        this();
    }

    public static void enableNativeProxy() {
        sCommandLine.set(new NativeCommandLine(getJavaSwitchesOrNull()));
    }

    public static CommandLine getInstance() {
        return sCommandLine.get();
    }

    @Nullable
    public static String[] getJavaSwitchesOrNull() {
        CommandLine r10 = sCommandLine.get();
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getCommandLineArguments();
    }

    public static void init(@Nullable String[] r10) {
        setInstance(new JavaCommandLine(r10));
    }

    public static void initFromFile(String r10) {
        char[] r11 = readFileAsUtf8(r10);
        if (r11 != null) goto L5;
        String[] r12 = null;
    L6:
        init(r12);
        return;
    L5:
        r12 = tokenizeQuotedArguments(r11);
        goto L6
    }

    public static boolean isInitialized() {
        if (sCommandLine.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static char[] readFileAsUtf8(String r10) {
        File r11 = new File(r10);
        FileReader r12 = new FileReader(r11);     // Catch: IOException -> L13
        char[] r13 = new char[(int) r11.length()];     // Catch: Throwable -> L7
        char[] r14 = Arrays.copyOfRange(r13, 0, r12.read(r13));     // Catch: Throwable -> L7
        r12.close();     // Catch: IOException -> L13
        return r14;
    L7:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L13
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L13
    L13:
        return null;
    }

    @VisibleForTesting
    public static void reset() {
        setInstance(null);
    }

    private static void setInstance(CommandLine r10) {
        CommandLine r11 = sCommandLine.getAndSet(r10);
        if (r11 == null) goto L6;
        r11.destroy();
        return;
    }

    @VisibleForTesting
    public static void setInstanceForTesting(CommandLine r10) {
        setInstance(r10);
    }

    @VisibleForTesting
    static String[] tokenizeQuotedArguments(char[] r10) {
        if (r10.length > 65536) goto L38;
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        StringBuilder r13 = null;
        int r14 = 0;
        char r15 = 0;
    L5:
        if (r14 >= r12) goto L31;
        char r16 = r10[r14];
        if (r15 == 0) goto L9;
    L12:
        if (r16 != r15) goto L22;
    L13:
        if (r13 != null) goto L15;
    L19:
        if (r15 != 0) goto L21;
        r15 = r16;
    L30:
        r14 = r14 + 1;
        goto L5
    L21:
        r15 = 0;
        goto L30
    L15:
        if (r13.length() <= 0) goto L19;
        if (r13.charAt(r13.length() - 1) != '\\') goto L19;
        r13.setCharAt(r13.length() - 1, r16);
        goto L30
    L22:
        if (r15 == 0) goto L24;
    L27:
        if (r13 != null) goto L29;
        r13 = new StringBuilder();
    L29:
        r13.append(r16);
        goto L30
    L24:
        if (Character.isWhitespace(r16) == false) goto L27;
        if (r13 == null) goto L30;
        r11.add(r13.toString());
        r13 = null;
        goto L30
    L9:
        if (r16 == '\'') goto L13;
        if (r16 == '\"') goto L13;
    L31:
        if (r13 == null) goto L36;
        if (r15 == 0) goto L34;
        android.util.Log.w(TAG, "Unterminated quoted string: " + r13);
    L34:
        r11.add(r13.toString());
    L36:
        return (String[]) r11.toArray(new String[r11.size()]);
    L38:
        throw new RuntimeException("Flags file too big: " + r10.length);
    }

    public abstract void appendSwitch(String r10);

    public abstract void appendSwitchWithValue(String r10, String r11);

    public abstract void appendSwitchesAndArguments(String[] r10);

    protected void destroy() {
    }

    protected abstract String[] getCommandLineArguments();

    public abstract String getSwitchValue(String r10);

    public String getSwitchValue(String r10, String r11) {
        String r12 = getSwitchValue(r10);
        if (TextUtils.isEmpty(r12) == false) goto L6;
        return r11;
    L6:
        return r12;
    }

    public abstract Map getSwitches();

    public abstract boolean hasSwitch(String r10);

    public boolean isNativeImplementation() {
        return false;
    }

    public abstract void removeSwitch(String r10);
}
