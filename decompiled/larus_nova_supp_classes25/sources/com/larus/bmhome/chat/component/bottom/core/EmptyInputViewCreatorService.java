package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mt8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/EmptyInputViewCreatorService;", "Lcom/larus/bmhome/chat/component/bottom/core/InputViewCreatorService;", "<init>", "()V", "stubCreateInputView", "", "viewStub", "Landroid/view/ViewStub;", "id", "", "(Landroid/view/ViewStub;Ljava/lang/Integer;)Ljava/lang/Void;", "stubCreateSpringInputView", "", "addCreateInputViewToViewGroup", "viewRoot", "Landroid/view/ViewGroup;", "findInputView", "Lcom/larus/bmhome/chat/component/bottom/core/InputView;", "createInputView", "Landroid/view/View;", "context", "Landroid/content/Context;", "createResourceBarView", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "setIsImmersiveSlidingFeedVertical", "inputView", "isVertical", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class EmptyInputViewCreatorService implements InputViewCreatorService {
    public static final EmptyInputViewCreatorService a = null;

    static {
        a = new EmptyInputViewCreatorService();
    }

    private EmptyInputViewCreatorService() {
    }

    public final void b(ViewGroup r1) {
    }

    public final void c(g9 r1, boolean r2) {
    }

    public final g9 f(ViewGroup r1) {
        return null;
    }

    public final void g(ViewStub r2) {
        Intrinsics.checkNotNullParameter(r2, "viewStub");
    }

    public final View d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new View(r2);
    }

    public final a e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        throw new UnsupportedOperationException("empty impl for resource item view");
    }

    public final View a(ViewStub r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "viewStub");
        throw new IllegalStateException("EmptyInputViewCreatorService");
    }
}
