package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ActionPanelUIUtil {
    public final Context a;
    public final Lazy b;

    public static final class a {
        public final ViewGroup a;
        public final View b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "UIViews(itemContainer=" + this.a + ", popupContainer=" + this.b + ')';
        }

        public a(RecyclerView r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "itemContainer");
            Intrinsics.checkNotNullParameter(r3, "popupContainer");
            this.a = r2;
            this.b = r3;
        }
    }

    public final Context getContext() {
        return this.a;
    }

    public ActionPanelUIUtil(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new ActionPanelUIUtil$partialLabelPaint$2(this));
    }
}
