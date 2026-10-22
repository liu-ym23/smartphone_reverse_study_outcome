package com.larus.bmhome.chat.markdown.videogroup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.double_post.view.AwemeRecommendContentView;
import com.larus.bmhome.video.CardRatioStrategy;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ContentCover;
import com.larus.bmhome.video.ContentDescription;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusMdVideoGroupV2Binding;
import com.larus.utils.e1;
import fh8.b;
import fh8.h;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rh8.d;
import rh8.j;
import usc.e;
import usc.f;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0002J.\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0002J,\u0010-\u001a\u00020$2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0002J\u0012\u00101\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u000100H\u0002J\u0012\u00103\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u000100H\u0002J\b\u00104\u001a\u000205H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/bmhome/chat/markdown/videogroup/VideoGroupV2Widget;", "Landroid/widget/FrameLayout;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusMdVideoGroupV2Binding;", "mobMessage", "Lcom/larus/im/bean/message/Message;", "mobConversationId", "", "mobBotId", "mobCurrentPage", "mobPreviousPage", "mobLruSet", "Lcom/larus/bmhome/chat/search/LruSet;", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "bindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", ChatDraftItem.TYPE_TEXT, "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "maxWidth", "", "payload", "", "", "updateVideoTitle", "", "showVideoTitle", "", "videoTitle", "updateVideoContent", "videoGroupData", "Lcom/larus/bmhome/chat/markdown/videogroup/VideoGroupData;", "convert2Content", "Lcom/larus/bmhome/video/Content;", "openVideoActivity", "videoInfos", "", "Lcom/larus/bmhome/chat/search/VideoInfo;", "mobCardShow", "videoItem", "mobCardClick", "asView", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VideoGroupV2Widget extends FrameLayout implements f {
    public static final int i = 0;
    public LarusMdVideoGroupV2Binding a;
    public Message b;
    public String c;
    public String d;
    public String e;
    public String f;
    public LruSet<String> g;
    public fh8.f h;

    public static final class a {
    }

    public final void a() {
    }

    public final View asView() {
        return this;
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final void f() {
    }

    static {
        i = i5.y0(c.b(2130971205, null, 2131166779));
    }

    public VideoGroupV2Widget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public VideoGroupV2Widget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public final Size d(TextView r44, Spanned r45, e r46, int r47, Map<String, ? extends Object> r48) {
        Intrinsics.checkNotNullParameter(r44, "textView");
        Intrinsics.checkNotNullParameter(r45, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r46, "span");
        LarusMdVideoGroupV2Binding r4 = null;
        if (r48 == null) goto L5;
        fh8.f r5 = h.b(r48);
    L6:
        this.h = r5;
        if (r5 == null) goto L9;
        Message r6 = r5.b;
    L10:
        this.b = r6;
        if (r5 == null) goto L13;
        String r7 = r5.c;
    L14:
        this.c = r7;
        if (r5 == null) goto L17;
        String r8 = r5.e;
    L18:
        this.e = r8;
        if (r5 == null) goto L21;
        String r9 = r5.f;
    L22:
        this.f = r9;
        if (r5 == null) goto L25;
        String r10 = r5.d;
    L26:
        this.d = r10;
        if (r5 == null) goto L29;
        LruSet<String> r11 = r5.g;
    L30:
        this.g = r11;
    L109:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return new Size(0, 0);
    L33:
        if (r46.k().length() != 0) goto L35;
        boolean r12 = true;
    L36:
        String r13 = "";
        if (r12 == false) goto L39;
        final String r14 = r46.h();     // Catch: Exception -> L109
    L48:
        String r15 = "{}";
        if (r14 != null) goto L51;
        r14 = "{}";
    L51:
        rh8.a r16 = (rh8.a) b.a(r46, new d(r14));     // Catch: Exception -> L109
        String r2 = r46.l();     // Catch: Exception -> L58
        if (r2 == null) goto L56;
        r15 = r2;
    L56:
        JSONObject r17 = new JSONObject(r15);     // Catch: Exception -> L58
    L59:
        boolean r3 = r17.optBoolean("video_title_show");
        View r18 = LayoutInflater.from(getContext()).inflate(2131562960, this, false);
        addView(r18);
        int r19 = 2131392285;
        AwemeRecommendContentView r110 = ViewBindings.findChildViewById(r18, 2131392285);
        if (r110 == null) goto L108;
        r19 = 2131392247;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r18, 2131392247);
        if (r111 == null) goto L108;
        this.a = new LarusMdVideoGroupV2Binding((LinearLayout) r18, r110, r111);
        String r20 = r16.a();
        LarusMdVideoGroupV2Binding r112 = this.a;
        if (r112 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L66:
        TextView r113 = r112.c;
        if (r3 == true) goto L69;
        Intrinsics.checkNotNull(r113);
        e1.o(r113);
    L74:
        Intrinsics.checkNotNull(r16);
        LarusMdVideoGroupV2Binding r21 = this.a;
        if (r21 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L77:
        AwemeRecommendContentView r22 = r21.b;
        List<VideoInfo> r23 = r16.b();
        if (r23 == null) goto L91;
        VideoInfo r24 = (VideoInfo) ListProtector.get(r23, 0);
        if (r24 == null) goto L91;
        String r114 = r24.getItemId();
        int r25 = ItemType.VIDEO.getValue();
        ContentDescription r115 = new ContentDescription(null, r24.getDescription(), 1, null);
        CardRatioStrategy r26 = CardRatioStrategy.FixRatio;
        String r36 = r24.getImageUrl();
        Integer r116 = r24.getWidth();
        if (r116 == null) goto L85;
        int r37 = r116.intValue();
    L86:
        Integer r117 = r24.getHeight();
        if (r117 == null) goto L89;
        int r38 = r117.intValue();
    L90:
        ContentCover r118 = new ContentCover(new IconImage(null, null, new ImageObj(r36, r37, r38, null, null, 24, null), 3, null), null, null, 6, null);
        Content r27 = new Content(r114, Integer.valueOf(r25), null, null, r24.getAuthorInfo(), r118, r115, r24.getInteractionInfo(), null, null, null, null, null, r26, false, null, null, 122636, null);
    L92:
        r22.a(r27, new j(r16, this, r48, r44));
        List<VideoInfo> r0 = r16.b();
        if (r0 == null) goto L98;
        final VideoInfo r1 = (VideoInfo) ListProtector.get(r0, 0);
        LarusMdVideoGroupV2Binding r28 = this.a;
        if (r28 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L97:
        ExposureTrackerExtKt.a(r28.b, new rh8.e(r1, this));
    L98:
        LarusMdVideoGroupV2Binding r29 = this.a;
        if (r29 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L101:
        r29.a.measure(0, 0);
        LarusMdVideoGroupV2Binding r30 = this.a;
        if (r30 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L106:
        return new Size(r47, r4.a.getMeasuredHeight());
    L104:
        r4 = r30;
        goto L106
    L89:
        r38 = 0;
        goto L90
    L85:
        r37 = 0;
    L91:
        r27 = null;
        goto L92
    L69:
        Intrinsics.checkNotNull(r113);
        e1.x(r113);
        we8.a.b(r113, i5.t(), false, null, null, 12);
        r113.getLayoutParams().height = (int) we8.a.a(((Number) i5.y.getValue()).intValue(), false);
        if (r20 == null) goto L73;
        r13 = r20;
    L73:
        r113.setText(r13);
    L108:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r19)));
    L58:
        r17 = new JSONObject();
        goto L59
    L39:
        Message r31 = this.b;     // Catch: Exception -> L109
        if (r31 == null) goto L47;
        wc8.b r119 = wc8.b.a;     // Catch: Exception -> L109
        String r32 = r31.getMessageId();     // Catch: Exception -> L109
        if (r32 != null) goto L45;
        r32 = "";
    L45:
        r14 = r119.c(r32, r46.k(), "VideoGroupV2Widget");     // Catch: Exception -> L109
        if (r14 != null) goto L48;
    L47:
        r14 = wc8.b.a.b(r46.k(), "VideoGroupV2Widget");     // Catch: Exception -> L109
        goto L48
    L35:
        r12 = false;
        goto L36
    L29:
        r11 = null;
        goto L30
    L25:
        r10 = null;
        goto L26
    L21:
        r9 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
