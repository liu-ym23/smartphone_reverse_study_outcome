package com.bytedance.android.livesdk.interactivity.chatchannel.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.ChannelLinkSeatUserItemDecoration;
import com.bytedance.bdlocation.BuildConfig;
import ec2.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import r62.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/view/ChannelTrayListViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function1;", "Lp62/a;", BuildConfig.FLAVOR, "c", "Lkotlin/jvm/functions/Function1;", "getTrayClickCallback", "()Lkotlin/jvm/functions/Function1;", "setTrayClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "trayClickCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelTrayListViewV2 extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public final RecyclerView a;
    public final MultiTypeAdapter b;
    public Function1<? super p62.a, Unit> c;
    public b d;

    public ChannelTrayListViewV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelTrayListViewV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        b r0 = this.d;
        if (r0 == null) goto L6;
        MainThreadPostUtils.d(r0);
        return;
    }

    public final Function1<p62.a, Unit> getTrayClickCallback() {
        return this.c;
    }

    public final void setTrayClickCallback(Function1<? super p62.a, Unit> r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelTrayListViewV2(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ViewGroup.inflate(r3, 2131565305, this);
        RecyclerView r6 = findViewById(2131362511);
        this.a = r6;
        MultiTypeAdapter r7 = new MultiTypeAdapter();
        this.b = r7;
        r7.z2(p62.a.class, new ChannelTrayListViewBinder(new r62.a(this)));
        SSLinearLayoutManager r8 = new SSLinearLayoutManager(getContext(), 0);
        r6.setAdapter(r7);
        r6.setLayoutManager(r8);
        r6.addItemDecoration(new ChannelLinkSeatUserItemDecoration(UtilityKotlinExtentionsKt.i(8)));
        r7.notifyDataSetChanged();
        if (((Boolean) e1.a.getValue()).booleanValue() == true) goto L5;
        r6.setHorizontalFadingEdgeEnabled(false);
        r6.setVerticalFadingEdgeEnabled(false);
    L5:
        r6.addOnScrollListener(new ChannelTrayListViewV2$initRecyclerView$2(this));
    }

    public /* synthetic */ ChannelTrayListViewV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
