package com.ss.android.lark.chat.message.menu.v2.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.EmojiListView;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ssb.b;
import z5c.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0012J(\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J\b\u0010 \u001a\u00020\u0014H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/emoji/BuiltInEmojiPanelView;", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiListView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "showColumn", "emojiHeightPx", "emojiContainerHeightPx", "emojiContainerWidthPx", "panelHorizontalPaddingPx", "likeInFront", BuildConfig.FLAVOR, "setEmojiSize", BuildConfig.FLAVOR, "emojiHeight", "emojiContainerHeight", "emojiContainerWidth", "panelHorizontalPadding", "setLikeInFront", "value", "onSizeChanged", SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "initView", "computeReactionParams", "Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;", "parentWidth", "prepareEmojiData", BuildConfig.FLAVOR, "Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemData;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BuiltInEmojiPanelView extends EmojiListView {
    public final int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        int r0 = getWidth();
        int r5 = this.e;
        int r3 = this.f;
        int r2 = this.g;
        int r7 = this.h;
        int r9 = this.d;
        int r4 = ((r0 - (r2 * r9)) - (r7 * 2)) / (r9 - 1);
        int r6 = (r2 + r4) * r9;
        d(new ssb.a(r2, r3, r4, r5, r6, r7, (r0 - r7) - r6, r9));
        ArrayList r1 = new ArrayList();
        DefaultEmojiPanelData r8 = k2c.a.a().a();
        List r10 = CollectionsKt.toList(k2c.a.a().N(this.i));
        if (r8 != null) goto L5;
    L42:
        setData(r1);
        return;
    L5:
        if (r8.d() == true) goto L42;
        r1.add(new b.d(v2c.a.getResources(getContext()).getString(2131891136), null));
        int r11 = b6b.a.a;
        r1.add(new b.a(b6b.a.a(r10, n3.e)));
        List r12 = r8.a;
        ArrayList r13 = new ArrayList();
        Iterator r14 = ((ArrayList) r12).iterator();
    L8:
        boolean r15 = true;
        if (r14.hasNext() == false) goto L16;
        Object r16 = r14.next();
        if (((DefaultEmojiPanelData.a) r16).getType() != DefaultEmojiPanelData.Type.UNKNOWN) goto L14;
        r15 = false;
    L14:
        if (r15 == false) goto L8;
        r13.add(r16);
        goto L8
    L16:
        Iterator r17 = r13.iterator();
    L18:
        if (r17.hasNext() == false) goto L41;
        DefaultEmojiPanelData.a r18 = (DefaultEmojiPanelData.a) r17.next();
        if (r18.c.length() != 0) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == true) goto L25;
    L27:
        String r20 = r18.c;
    L28:
        Intrinsics.checkNotNull(r20);
        r1.add(new b.d(r20, r18.b));
        List r21 = r18.b();
        ArrayList r22 = new ArrayList();
        Iterator r23 = ((ArrayList) r21).iterator();
    L30:
        if (r23.hasNext() == false) goto L34;
        Object r24 = r23.next();
        if (((com.ss.android.lark.newemoji.larkemoji.a) r24).c(false) == false) goto L30;
        r22.add(r24);
        goto L30
    L34:
        Iterator r25 = r22.iterator();
        int r26 = 0;
    L36:
        if (r25.hasNext() == false) goto L18;
        Object r27 = r25.next();
        int r28 = r26 + 1;
        if (r26 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        r1.add(new b.c((com.ss.android.lark.newemoji.larkemoji.a) r27, true, n3.d, Integer.valueOf(r28)));
        r26 = r28;
        goto L36
    L25:
        if (r18.getType() != DefaultEmojiPanelData.Type.DEFAULT) goto L27;
        r20 = v2c.a.getResources(getContext()).getString(2131890747);
        goto L28
    L22:
        r19 = false;
        goto L23
    L41:
        r1.add(new b.b(56));
        goto L42
    }

    public BuiltInEmojiPanelView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = 7;
        this.e = UIHelper.dp2px(30.0f);
        this.f = UIHelper.dp2px(46.0f);
        this.g = UIHelper.dp2px(42.0f);
        this.h = UIHelper.dp2px(16.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setLikeInFront(boolean r2) {
        if (this.i != r2) goto L5;
        return;
    L5:
        this.i = r2;
        if (getWidth() <= 0) goto L9;
        e();
        return;
    }

    public BuiltInEmojiPanelView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.d = 7;
        this.e = UIHelper.dp2px(30.0f);
        this.f = UIHelper.dp2px(46.0f);
        this.g = UIHelper.dp2px(42.0f);
        this.h = UIHelper.dp2px(16.0f);
    }

    public BuiltInEmojiPanelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.d = 7;
        this.e = UIHelper.dp2px(30.0f);
        this.f = UIHelper.dp2px(46.0f);
        this.g = UIHelper.dp2px(42.0f);
        this.h = UIHelper.dp2px(16.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.FrameLayout*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L7;
        if (r1 == r3) goto L8;
        Log.i("BuildInEmojiPanelView", "onSizeChanged, w: " + r1 + ", oldw: " + r3);
        e();
        return;
    L8:
        return;
    }
}
