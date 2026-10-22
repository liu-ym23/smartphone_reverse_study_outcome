package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.p;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/FirstMessagePaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/IUpdateHeightDecoration;", "mProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/FirstMessagePaddingDecoration$IHashMoreProvider;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/FirstMessagePaddingDecoration$IHashMoreProvider;)V", "extraHeight", BuildConfig.FLAVOR, "getItemOffsets", BuildConfig.FLAVOR, "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "updateHeight", "height", "isEnable", BuildConfig.FLAVOR, "IHashMoreProvider", "PaddingTopProvider", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FirstMessagePaddingDecoration extends RecyclerView.ItemDecoration implements z3b.a {
    public final a a;
    public float b;

    public interface a {
        boolean a();
    }

    @Override // z3b.a
    public final boolean isEnable() {
        return true;
    }

    public FirstMessagePaddingDecoration(p r2) {
        Intrinsics.checkNotNullParameter(r2, "mProvider");
        this.a = r2;
    }

    @Override // z3b.a
    public final void c(float r1) {
        this.b = r1;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        RecyclerView.LayoutParams r6 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        if (r6.getAbsoluteAdapterPosition() == 0) goto L5;
    L8:
        r2.set(0, 0, 0, 0);
        return;
    L5:
        if (this.a.a() == true) goto L8;
        r2.set(0, (int) this.b, 0, 0);
    }
}
