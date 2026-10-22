package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class PostContentBlock$showTextSelect$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> $cell;
    final /* synthetic */ y6b.a<PostContentVO> $item;
    final /* synthetic */ Function1<y6b.a<PostContentVO>, Unit> $onTextSelectedAction;
    final /* synthetic */ PostContentBlock this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public PostContentBlock$showTextSelect$2(Function1<? super y6b.a<PostContentVO>, Unit> r1, y6b.a<PostContentVO> r2, PostContentBlock r3, com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r4) {
        this.$onTextSelectedAction = r1;
        this.$item = r2;
        this.this$0 = r3;
        this.$cell = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m274invoke() {
        Function1<y6b.a<PostContentVO>, Unit> r0 = this.$onTextSelectedAction;
        if (r0 == null) goto L5;
        r0.invoke(this.$item);
        return;
    L5:
        PostContentBlock r1 = this.this$0;
        e6b.b r2 = this.$cell;
        y6b.a<PostContentVO> r3 = this.$item;
        int r4 = PostContentBlock.o;
        r1.getClass();
        if ((r2 instanceof e6b.b) == false) goto L8;
        e6b.b r5 = r2;
    L9:
        if (r5 == null) goto L13;
        r5.e(r1, r3);
        return;
    L13:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m274invoke();
        return Unit.INSTANCE;
    }
}
