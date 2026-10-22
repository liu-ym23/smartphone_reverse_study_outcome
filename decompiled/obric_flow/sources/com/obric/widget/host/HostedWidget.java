package com.obric.widget.host;

import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH&J\b\u0010\u0014\u001a\u00020\u000fH&JI\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/obric/widget/host/HostedWidget;", "", "id", "", "getId", "()Ljava/lang/String;", STGroup.DICT_KEY, "Lcom/obric/widget/host/WidgetInstanceKey;", "getKey", "()Lcom/obric/widget/host/WidgetInstanceKey;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restore", "onForeground", "onShow", "onHide", "dispatchDataChanged", "", "widgetData", "reason", "dataVersion", "", "updatedAt", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Z", "destroy", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HostedWidget {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean dispatchDataChanged(HostedWidget r5, String r10, String r11, Long r12, Long r13, String r14) {
            return false;
        }

        public static /* synthetic */ boolean dispatchDataChanged$default(HostedWidget r5, String r10, String r11, Long r12, Long r13, String r14, int r15, Object r16) {
            if (r16 != null) goto L21;
            if ((r15 & 1) == 0) goto L7;
            r10 = null;
        L7:
            if ((r15 & 2) == 0) goto L10;
            r11 = null;
        L10:
            if ((r15 & 4) == 0) goto L13;
            r12 = null;
        L13:
            if ((r15 & 8) == 0) goto L16;
            r13 = null;
        L16:
            if ((r15 & 16) == 0) goto L19;
            r14 = null;
        L19:
            return r5.dispatchDataChanged(r10, r11, r12, r13, r14);
        L21:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchDataChanged");
        }

        public static void onForeground(HostedWidget r5) {
            r5.onShow();
        }
    }

    void destroy();

    boolean dispatchDataChanged(String r5, String r10, Long r11, Long r12, String r13);

    String getId();

    WidgetInstanceKey getKey();

    View getView();

    void onForeground();

    void onHide();

    void onShow();

    Object refresh(Continuation<? super Unit> r5);

    Object restore(Continuation<? super Unit> r5);
}
