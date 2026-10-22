package com.larus.bmhome.chat.standarduikit.videogroup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import zn8.k;
import zn8.l;
import zn8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 B2\u00020\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003:\u0001BB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100+2\u0006\u0010,\u001a\u00020-H\u0002J\u001a\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u0010H\u0016J\u0018\u00102\u001a\u0002032\u0006\u00100\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u0002032\u0006\u0010,\u001a\u00020-H\u0002J(\u00106\u001a\u0002032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020;2\u0006\u00104\u001a\u00020\u0005H\u0002J(\u0010<\u001a\u0002032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020;2\u0006\u00104\u001a\u00020\u0005H\u0002J\u001a\u0010=\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0006\u0010A\u001a\u000203R\u000e\u0010\u000e\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/videogroup/view/RelatedVideoView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/IRelatedVideoView;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/VideoGroupViewInput;", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/VideoGroupViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "isTall", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "binding", "widgetHeight", "", "getWidgetHeight", "()I", "widgetWidth", "getWidgetWidth", "coverView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCoverView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "tvImageCaption", "Landroid/widget/TextView;", "getTvImageCaption", "()Landroid/widget/TextView;", "ciciSourceIcon", "Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "getCiciSourceIcon", "()Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "dySourceLabelView", "getDySourceLabelView", "titleView", "getTitleView", "contentView", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "videoTitleHeight", "calculatePaddingValues", "Lkotlin/Pair;", "sizeData", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/SizeData;", "sizeThatFits", "Landroid/util/Size;", "input", "preferredMaxWidth", "bindData", "", "output", "updateContainer", "updateIcon", "videoData", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/VideoData;", "isOversea", "trackData", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/TrackData;", "updateCoverImage", "updateTitle", "videoTitle", "", "showVideoTitle", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RelatedVideoView extends FrameLayout implements zn8.a {
    public static final /* synthetic */ int c = 0;
    public final zn8.a a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public RelatedVideoView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, false, 6);
    }

    public RelatedVideoView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, false, 4);
    }

    @Override // zn8.a
    public MarkdownSourceImageView getCiciSourceIcon() {
        return this.a.getCiciSourceIcon();
    }

    @Override // zn8.a
    public ViewGroup getContentView() {
        return this.a.getContentView();
    }

    @Override // zn8.a
    public SimpleDraweeView getCoverView() {
        return this.a.getCoverView();
    }

    @Override // zn8.a
    public SimpleDraweeView getDySourceLabelView() {
        return this.a.getDySourceLabelView();
    }

    @Override // zn8.a
    public TextView getTitleView() {
        return this.a.getTitleView();
    }

    @Override // zn8.a
    public TextView getTvImageCaption() {
        return this.a.getTvImageCaption();
    }

    @Override // zn8.a
    public int getWidgetHeight() {
        return this.a.getWidgetHeight();
    }

    @Override // zn8.a
    public int getWidgetWidth() {
        return this.a.getWidgetWidth();
    }

    public static Pair a(l r2) {
        if (r2.a == false) goto L6;
        return new Pair(Integer.valueOf(i5.Y()), Integer.valueOf(i5.q()));
    L6:
        if (r2.b == false) goto L13;
        if (r2.c == false) goto L10;
        int r3 = i5.r0();
    L11:
        Pair r0 = new Pair(Integer.valueOf(r3), Integer.valueOf(i5.Y()));
    L18:
        return r0;
    L10:
        r3 = i5.q();
        goto L11
    L13:
        if (r2.c == false) goto L15;
        int r4 = i5.r0();
    L16:
        r0 = new Pair(Integer.valueOf(r4), Integer.valueOf(i5.q()));
        goto L18
    L15:
        r4 = i5.q();
        goto L16
    }

    public RelatedVideoView(Context r2, AttributeSet r3, boolean r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        if (r4 == false) goto L11;
        zn8.a r6 = new o(r2, this);
    L12:
        this.a = r6;
        this.b = ((int) we8.a.a(((Number) i5.y.getValue()).intValue(), false)) + i5.q();
        return;
    L11:
        r6 = new k(r2, this);
        goto L12
    }
}
