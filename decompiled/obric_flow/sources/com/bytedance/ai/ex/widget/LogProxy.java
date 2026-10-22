package com.bytedance.ai.ex.widget;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J(\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J(\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J(\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J(\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/ex/widget/LogProxy;", "", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "v", "w", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LogProxy {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void d$default(LogProxy r5, String r10, String r11, Throwable r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 4) == 0) goto L6;
            r12 = null;
        L6:
            r5.d(r10, r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }

        public static /* synthetic */ void e$default(LogProxy r5, String r10, String r11, Throwable r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 4) == 0) goto L6;
            r12 = null;
        L6:
            r5.e(r10, r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }

        public static /* synthetic */ void i$default(LogProxy r5, String r10, String r11, Throwable r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 4) == 0) goto L6;
            r12 = null;
        L6:
            r5.i(r10, r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }

        public static /* synthetic */ void v$default(LogProxy r5, String r10, String r11, Throwable r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 4) == 0) goto L6;
            r12 = null;
        L6:
            r5.v(r10, r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
        }

        public static /* synthetic */ void w$default(LogProxy r5, String r10, String r11, Throwable r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 4) == 0) goto L6;
            r12 = null;
        L6:
            r5.w(r10, r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
        }
    }

    void d(String r5, String r10, Throwable r11);

    void e(String r5, String r10, Throwable r11);

    void i(String r5, String r10, Throwable r11);

    void v(String r5, String r10, Throwable r11);

    void w(String r5, String r10, Throwable r11);
}
