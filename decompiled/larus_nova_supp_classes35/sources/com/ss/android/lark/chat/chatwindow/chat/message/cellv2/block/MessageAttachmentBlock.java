package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageAttachmentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    public static final class a implements com.ss.android.lark.blueprint.k<View> {
        public a() {
            throw null;
        }

        public final View getView() {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessageAttachmentBlock$update$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "<unused var>", "Landroid/view/View;", "invoke", "(Landroid/view/View;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Boolean> {
        final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> $cell;
        final /* synthetic */ y6b.a<?> $data;
        final /* synthetic */ MessageAttachmentBlock this$0;

        public AnonymousClass1(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, MessageAttachmentBlock r2, y6b.a<?> r3) {
            this.$cell = r1;
            this.this$0 = r2;
            this.$data = r3;
            super(1);
        }

        public final Boolean invoke(View r3) {
            Intrinsics.checkNotNullParameter(r3, "<unused var>");
            e6b.b r4 = this.$cell;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 == null) goto L8;
            boolean r6 = r5.e(this.this$0, this.$data);
        L10:
            return Boolean.valueOf(r6);
        L8:
            r6 = false;
            goto L10
        L5:
            r5 = null;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((View) r1);
        }
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return null;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3, y6b.a<?> r4) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        Object r5 = r4.b();
        if ((r5 instanceof BaseTextContentVO) == false) goto L5;
        BaseTextContentVO r6 = (BaseTextContentVO) r5;
    L6:
        if (r6 == null) goto L8;
        List r7 = r6.f();
    L9:
        if (r7 != null) goto L12;
        r7 = CollectionsKt.emptyList();
    L12:
        if (r7.isEmpty() == false) goto L15;
        g(r3, null, IMMessageKeys$Slots.CONTENT);
        return;
    L15:
        ((a) r3.c(null, IMMessageKeys$Slots.CONTENT, new MessageAttachmentBlock$update$blockView$1(this))).getClass();
        throw null;
    L8:
        r7 = null;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
