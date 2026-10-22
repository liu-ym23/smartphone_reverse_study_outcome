package com.obric.feature.miniapp.widget;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&JV\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0004\u0012\u00020\u00030\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&JD\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J2\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/obric/feature/miniapp/widget/MiniAppHostView;", "", "updateWidget", "", "onSuccess", "Lkotlin/Function1;", "", "onFailure", "refreshAffected", "changedDomains", "", "reason", "Lkotlin/Function2;", "", "sendPayload", "payload", "waitForResult", "", "openPage", "args", "Landroid/os/Bundle;", "Lkotlin/Function0;", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MiniAppHostView {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void refreshAffected$default(MiniAppHostView r5, List r10, String r11, Function2 r12, Function1 r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 2) == 0) goto L6;
            r11 = null;
        L6:
            r5.refreshAffected(r10, r11, r12, r13);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshAffected");
        }

        public static /* synthetic */ void sendPayload$default(MiniAppHostView r5, String r10, boolean r11, Function1 r12, Function1 r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 2) == 0) goto L6;
            r11 = false;
        L6:
            r5.sendPayload(r10, r11, r12, r13);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPayload");
        }
    }

    void openPage(Bundle r5, Function0<Unit> r10, Function1<? super String, Unit> r11);

    void refreshAffected(List<String> r5, String r10, Function2<? super Integer, ? super List<String>, Unit> r11, Function1<? super String, Unit> r12);

    void sendPayload(String r5, boolean r10, Function1<? super String, Unit> r11, Function1<? super String, Unit> r12);

    void updateWidget(Function1<? super String, Unit> r5, Function1<? super String, Unit> r10);
}
