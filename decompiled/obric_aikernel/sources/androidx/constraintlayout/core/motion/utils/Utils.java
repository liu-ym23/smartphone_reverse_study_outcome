package androidx.constraintlayout.core.motion.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    static DebugHandle ourHandle;

    public interface DebugHandle {
        void message(String r10);
    }

    public Utils() {
    }

    private static int clamp(int r10) {
        int r11 = (r10 & (~(r10 >> 31))) - 255;
        return (r11 & (r11 >> 31)) + 255;
    }

    public static void log(String r10) {
        StackTraceElement r11 = new Throwable().getStackTrace()[1];
        String r12 = (r11.getMethodName() + "                  ").substring(0, 17);
        String r13 = ".(" + r11.getFileName() + ":" + r11.getLineNumber() + ")" + "    ".substring(Integer.toString(r11.getLineNumber()).length()) + r12;
        System.out.println(r13 + " " + r10);
        DebugHandle r14 = ourHandle;
        if (r14 == null) goto L6;
        r14.message(r13 + " " + r10);
        return;
    }

    public static void log(String r10, String r11) {
        System.out.println(r10 + " : " + r11);
    }

    public static void logStack(String r10, int r11) {
        StackTraceElement[] r12 = new Throwable().getStackTrace();
        int r13 = 1;
        int r14 = Math.min(r11, r12.length - 1);
        String r15 = " ";
    L3:
        if (r13 > r14) goto L5;
        StackTraceElement r16 = r12[r13];
        String r17 = ".(" + r12[r13].getFileName() + ":" + r12[r13].getLineNumber() + ") " + r12[r13].getMethodName();
        r15 = r15 + " ";
        System.out.println(r10 + r15 + r17 + r15);
        r13 = r13 + 1;
        goto L3
    }

    public static void loge(String r10, String r11) {
        System.err.println(r10 + " : " + r11);
    }

    public static int rgbaTocColor(float r10, float r11, float r12, float r13) {
        int r14 = clamp((int) (r10 * 255.0f));
        int r15 = clamp((int) (r11 * 255.0f));
        int r16 = clamp((int) (r12 * 255.0f));
        int r17 = r14 << 16;
        return ((r17 | (clamp((int) (r13 * 255.0f)) << 24)) | (r15 << 8)) | r16;
    }

    public static void setDebugHandle(DebugHandle r10) {
        ourHandle = r10;
    }

    public static void socketSend(String r10) {
        OutputStream r11 = new Socket("127.0.0.1", 5327).getOutputStream();     // Catch: IOException -> L4
        r11.write(r10.getBytes());     // Catch: IOException -> L4
        r11.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public int getInterpolatedColor(float[] r10) {
        int r11 = clamp((int) (((float) Math.pow(r10[0], 0.45454545454545453d)) * 255.0f));
        int r12 = clamp((int) (((float) Math.pow(r10[1], 0.45454545454545453d)) * 255.0f));
        return (((r11 << 16) | (clamp((int) (r10[3] * 255.0f)) << 24)) | (r12 << 8)) | clamp((int) (((float) Math.pow(r10[2], 0.45454545454545453d)) * 255.0f));
    }
}
