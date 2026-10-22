package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.model.SwitchResolutionDialogConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR=\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR?\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/ResolutionItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", LiveEndPageData.TAG_NAME, "selectedItem", "", "a", "Lkotlin/jvm/functions/Function1;", "getSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "selectedCallback", "msg", "b", "getToastAction", "setToastAction", "toastAction", "", "getHighFramerateThresh", "()I", "highFramerateThresh", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResolutionItemView extends ConstraintLayout {
    public Function1<? super String, Unit> a;
    public Function1<? super String, Unit> b;
    public ConstraintLayout c;
    public TextView d;
    public TextView e;
    public View f;
    public TextView g;
    public final SwitchResolutionDialogConfig h;

    public final int getHighFramerateThresh() {
        return ((com.bytedance.android.livesdk.config.i0) j40.i.a.getValue()).e();
    }

    public final Function1<String, Unit> getSelectedCallback() {
        return this.a;
    }

    public final Function1<String, Unit> getToastAction() {
        return this.b;
    }

    public final void setSelectedCallback(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setToastAction(Function1<? super String, Unit> r1) {
        this.b = r1;
    }

    public ResolutionItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = ResolutionItemView$selectedCallback$1.INSTANCE;
        this.h = (SwitchResolutionDialogConfig) com.bytedance.android.livesdk.f3.a.getValue();
    }
}
