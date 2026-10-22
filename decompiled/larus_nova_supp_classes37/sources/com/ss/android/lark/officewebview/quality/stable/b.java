package com.ss.android.lark.officewebview.quality.stable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@FunctionalInterface
public interface b {

    public static final class a {
        public boolean a;
        public boolean b;
        public boolean c;
        public int d;
        public int e;
        public boolean f;

        public final String toString() {
            return "BlankCheckResult(isSuccess=" + this.a + ", isBlank=" + this.b + ", isPureColor=" + this.c + ", pureColorArgb=" + this.d + ", adviceColorDiffEsp=-1, colorCounts=" + this.e + ", isTTWebView=" + this.f + ')';
        }

        public a() {
        }
    }
}
