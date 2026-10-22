package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.obric.assistant.omnidetailpage.localmedia.TaskLocalAudioButtonView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0007H\u0002J\f\u0010#\u001a\u00020\u0016*\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskLocalFileView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardView", "Landroid/widget/LinearLayout;", "iconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "titleView", "Landroid/widget/TextView;", "typeView", "playButton", "Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalAudioButtonView;", "boundPath", "", "bind", "", "item", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$LocalFile;", "onRecycled", "refreshPlayButton", "path", "resolveColor", "attrRes", "colorRes", "showAudioOpenFailedToast", "showAudioFileNotExistToast", "showAudioFailureToast", "messageRes", "setCardBackground", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskLocalFileView extends OmniDetailVerticalLineFrameLayout {
    public static final /* synthetic */ int i = 0;
    public final LinearLayout c;
    public final SimpleDraweeView d;
    public final TextView e;
    public final TextView f;
    public final TaskLocalAudioButtonView g;
    public String h;

    public TaskLocalFileView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TaskLocalFileView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final void setCardBackground(LinearLayout r2) {
        r2.setBackgroundResource(2131244549);
    }

    public TaskLocalFileView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        LinearLayout r16 = new LinearLayout(r13);
        r16.setOrientation(0);
        r16.setGravity(16);
        r16.setPadding(i5.q(), i5.q(), i5.q(), i5.q());
        setCardBackground(r16);
        this.c = r16;
        View r1 = new SimpleDraweeView(r13);
        this.d = r1;
        TextView r2 = new TextView(r13);
        r2.setTextSize(0, i5.q());
        r2.setTypeface(Typeface.create("PingFang SC", 0));
        r2.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        this.e = r2;
        TextView r3 = new TextView(r13);
        r3.setTextSize(0, i5.m());
        r3.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972081, getContext(), 2131103143)));
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        this.f = r3;
        TaskLocalAudioButtonView r5 = new TaskLocalAudioButtonView(r13, null, 6, 0);
        this.g = r5;
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        setPadding(i5.q(), i5.j0(), i5.q(), i5.j0());
        addView(r16, new FrameLayout.LayoutParams(-1, -2));
        r16.addView(r1, new LinearLayout.LayoutParams(i5.E(), i5.E()));
        LinearLayout r4 = new LinearLayout(r13);
        r4.setOrientation(1);
        r4.setGravity(16);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        r17.setMarginStart(i5.q());
        r17.setMarginEnd(i5.q());
        r16.addView(r4, r17);
        r4.addView(r2, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-1, -2);
        r18.topMargin = i5.Y();
        Unit r19 = Unit.INSTANCE;
        r4.addView(r3, r18);
        r16.addView(r5, new LinearLayout.LayoutParams(i5.J(), i5.J()));
    }

    public /* synthetic */ TaskLocalFileView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
