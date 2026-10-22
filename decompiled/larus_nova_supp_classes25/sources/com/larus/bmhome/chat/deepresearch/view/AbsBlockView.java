package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.module.ImageBlock;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.block.BannerBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CodeBlock;
import com.larus.im.bean.message.block.GenImageBlock;
import com.larus.im.bean.message.block.LinkReaderBlock;
import com.larus.im.bean.message.block.LocalLifeBlock;
import com.larus.im.bean.message.block.ResearchStatusBlock;
import com.larus.im.bean.message.block.RoutePlanBlock;
import com.larus.im.bean.message.block.SearchQueryBlock;
import com.larus.im.bean.message.block.SearchResultBlock;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.VideoReaderBlock;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J*\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H&J\b\u0010\u0015\u001a\u00020\rH\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/view/AbsBlockView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "bindData", "data", "Lcom/larus/im/bean/message/block/Block;", "extra", "", "", "", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class AbsBlockView extends LinearLayout {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static GenImageBlock a(Block r0) {
            if (r0 == null) goto L6;
            BlockContent r1 = r0.getContent();
            if (r1 == null) goto L6;
            return r1.getGenImageBlock();
        L6:
            return null;
        }

        public static ImageBlock b(Block r4) {
            if (r4 != null) goto L4;
        L6:
            boolean r0 = false;
        L7:
            String r1 = null;
            if (r0 == true) goto L10;
            return null;
        L10:
            ImageBlock r2 = (ImageBlock) com.larus.utils.l.b(r4, "extra_key_image_block");
            if (r2 != null) goto L17;
            Gson r3 = new Gson();
            BlockContent r5 = r4.getContent();
            if (r5 == null) goto L15;
            r1 = r5.getImageBlock();
        L15:
            ImageBlock r6 = (ImageBlock) GsonProtectorUtils.fromJson(r3, r1, ImageBlock.class);
            com.larus.utils.l.c(r4, "extra_key_image_block", r6);
            return r6;
        L17:
            return r2;
        L4:
            if (r4.getBlockType() != j.s) goto L6;
            r0 = true;
            goto L7
        }

        public static List c(Block r4) {
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
            if (r4 == null) goto L6;
            Integer r2 = Integer.valueOf(r4.getBlockType());     // Catch: Throwable -> L27
        L7:
            int r3 = j.s;     // Catch: Throwable -> L27
            if (r2 != null) goto L11;
        L18:
            int r5 = j.q;     // Catch: Throwable -> L27
            if (r2 != null) goto L22;
            return null;
        L22:
            if (r2.intValue() != r5) goto L36;
            int r6 = AbsBlockView.a;     // Catch: Throwable -> L27
            GenImageBlock r7 = a(r4);     // Catch: Throwable -> L27
            if (r7 != null) goto L26;
            return null;
        L26:
            return r7.images;
        L36:
            return null;
        L11:
            if (r2.intValue() != r3) goto L18;
            int r8 = AbsBlockView.a;     // Catch: Throwable -> L27
            ImageBlock r9 = b(r4);     // Catch: Throwable -> L27
            if (r9 == null) goto L33;
            List<SearchImageInfo> r10 = r9.images;     // Catch: Throwable -> L27
            if (r10 != null) goto L17;
            return null;
        L17:
            return CollectionsKt.filterNotNull(r10);
        L33:
            return null;
        L6:
            r2 = null;
        L27:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            Throwable r12 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (r12 == null) goto L31;
            FLogger.a.i("AbsBlockView", r12.toString());
        L31:
            return null;
        }

        public static String d(Block r4) {
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L102
            if (r4 == null) goto L6;
            Integer r2 = Integer.valueOf(r4.getBlockType());     // Catch: Throwable -> L102
        L7:
            int r3 = j.o;     // Catch: Throwable -> L102
            if (r2 != null) goto L11;
        L18:
            int r5 = j.s;     // Catch: Throwable -> L102
            if (r2 != null) goto L22;
        L27:
            int r6 = j.q;     // Catch: Throwable -> L102
            if (r2 != null) goto L31;
        L36:
            int r7 = j.p;     // Catch: Throwable -> L102
            if (r2 != null) goto L40;
        L47:
            int r8 = j.n;     // Catch: Throwable -> L102
            if (r2 != null) goto L51;
        L58:
            int r9 = j.m;     // Catch: Throwable -> L102
            if (r2 != null) goto L62;
        L69:
            int r10 = j.k;     // Catch: Throwable -> L102
            if (r2 != null) goto L73;
        L80:
            int r11 = j.l;     // Catch: Throwable -> L102
            if (r2 != null) goto L84;
        L91:
            int r12 = j.x;     // Catch: Throwable -> L102
            if (r2 != null) goto L95;
            return null;
        L95:
            if (r2.intValue() != r12) goto L123;
            BlockContent r13 = r4.getContent();     // Catch: Throwable -> L102
            if (r13 == null) goto L124;
            RoutePlanBlock r14 = r13.getRoutePlanBlock();     // Catch: Throwable -> L102
            if (r14 != null) goto L101;
            return null;
        L101:
            return r14.toolName;
        L124:
            return null;
        L123:
            return null;
        L84:
            if (r2.intValue() != r11) goto L91;
            BlockContent r15 = r4.getContent();     // Catch: Throwable -> L102
            if (r15 == null) goto L120;
            SearchResultBlock r16 = r15.getSearchResultBlock();     // Catch: Throwable -> L102
            if (r16 != null) goto L90;
            return null;
        L90:
            return r16.toolName;
        L120:
            return null;
        L73:
            if (r2.intValue() != r10) goto L80;
            BlockContent r17 = r4.getContent();     // Catch: Throwable -> L102
            if (r17 == null) goto L118;
            SearchQueryBlock r18 = r17.getSearchQueryBlock();     // Catch: Throwable -> L102
            if (r18 != null) goto L79;
            return null;
        L79:
            return r18.toolName;
        L118:
            return null;
        L62:
            if (r2.intValue() != r9) goto L69;
            BlockContent r19 = r4.getContent();     // Catch: Throwable -> L102
            if (r19 == null) goto L116;
            LinkReaderBlock r20 = r19.getLinkReaderBlock();     // Catch: Throwable -> L102
            if (r20 != null) goto L68;
            return null;
        L68:
            return r20.toolName;
        L116:
            return null;
        L51:
            if (r2.intValue() != r8) goto L58;
            BlockContent r21 = r4.getContent();     // Catch: Throwable -> L102
            if (r21 == null) goto L114;
            VideoReaderBlock r22 = r21.getVideoReaderBlock();     // Catch: Throwable -> L102
            if (r22 != null) goto L57;
            return null;
        L57:
            return r22.toolName;
        L114:
            return null;
        L40:
            if (r2.intValue() != r7) goto L47;
            BlockContent r23 = r4.getContent();     // Catch: Throwable -> L102
            if (r23 == null) goto L112;
            LocalLifeBlock r24 = r23.getLocalLifeBlock();     // Catch: Throwable -> L102
            if (r24 != null) goto L46;
            return null;
        L46:
            return r24.toolName;
        L112:
            return null;
        L31:
            if (r2.intValue() != r6) goto L36;
            int r25 = AbsBlockView.a;     // Catch: Throwable -> L102
            GenImageBlock r26 = a(r4);     // Catch: Throwable -> L102
            if (r26 != null) goto L35;
            return null;
        L35:
            return r26.toolName;
        L22:
            if (r2.intValue() != r5) goto L27;
            int r27 = AbsBlockView.a;     // Catch: Throwable -> L102
            ImageBlock r28 = b(r4);     // Catch: Throwable -> L102
            if (r28 != null) goto L26;
            return null;
        L26:
            return r28.toolName;
        L11:
            if (r2.intValue() != r3) goto L18;
            BlockContent r29 = r4.getContent();     // Catch: Throwable -> L102
            if (r29 == null) goto L108;
            CodeBlock r30 = r29.getCodeBlock();     // Catch: Throwable -> L102
            if (r30 != null) goto L17;
            return null;
        L17:
            return r30.toolName;
        L108:
            return null;
        L6:
            r2 = null;
        L102:
            th = move-exception;
            Result.Companion r31 = Result.Companion;
            Throwable r32 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (r32 == null) goto L106;
            FLogger.a.i("AbsBlockView", r32.toString());
        L106:
            return null;
        }

        public static void e(SimpleDraweeView r7, Block r8) {
            if (r7 == null) goto L239;
            if (r8 == null) goto L260;
            Context r0 = r7.getContext();
            if (r0 != null) goto L8;
            return;
        L8:
            int r1 = r8.getBlockType();
            String r4 = null;
            if (r1 != j.e) goto L31;
            boolean r2 = v19.h.a;
            if (v19.h.b(r0) == true) goto L21;
            GenericDraweeHierarchy r3 = r7.getHierarchy();
            if (r3 == null) goto L15;
            r3.setPlaceholderImage(2131242939);
        L15:
            BlockContent r9 = r8.getContent();
            if (r9 == null) goto L20;
            TextBlock r10 = r9.getTextBlock();
            if (r10 == null) goto L20;
            r4 = r10.iconUrl;
        L20:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L21:
            GenericDraweeHierarchy r5 = r7.getHierarchy();
            if (r5 == null) goto L24;
            r5.setPlaceholderImage(2131242940);
        L24:
            BlockContent r11 = r8.getContent();
            if (r11 == null) goto L29;
            TextBlock r12 = r11.getTextBlock();
            if (r12 == null) goto L29;
            r4 = r12.iconUrlDark;
        L29:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L31:
            if (r1 != j.k) goto L53;
            boolean r6 = v19.h.a;
            if (v19.h.b(r0) == true) goto L43;
            GenericDraweeHierarchy r13 = r7.getHierarchy();
            if (r13 == null) goto L37;
            r13.setPlaceholderImage(2131242941);
        L37:
            BlockContent r14 = r8.getContent();
            if (r14 == null) goto L42;
            SearchResultBlock r15 = r14.getSearchResultBlock();
            if (r15 == null) goto L42;
            r4 = r15.iconUrl;
        L42:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L43:
            GenericDraweeHierarchy r16 = r7.getHierarchy();
            if (r16 == null) goto L46;
            r16.setPlaceholderImage(2131242942);
        L46:
            BlockContent r17 = r8.getContent();
            if (r17 == null) goto L51;
            SearchResultBlock r18 = r17.getSearchResultBlock();
            if (r18 == null) goto L51;
            r4 = r18.iconUrlDark;
        L51:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L53:
            if (r1 != j.l) goto L75;
            boolean r19 = v19.h.a;
            if (v19.h.b(r0) == true) goto L65;
            GenericDraweeHierarchy r20 = r7.getHierarchy();
            if (r20 == null) goto L59;
            r20.setPlaceholderImage(2131242945);
        L59:
            BlockContent r21 = r8.getContent();
            if (r21 == null) goto L64;
            SearchResultBlock r22 = r21.getSearchResultBlock();
            if (r22 == null) goto L64;
            r4 = r22.iconUrl;
        L64:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L65:
            GenericDraweeHierarchy r23 = r7.getHierarchy();
            if (r23 == null) goto L68;
            r23.setPlaceholderImage(2131242946);
        L68:
            BlockContent r24 = r8.getContent();
            if (r24 == null) goto L73;
            SearchResultBlock r25 = r24.getSearchResultBlock();
            if (r25 == null) goto L73;
            r4 = r25.iconUrlDark;
        L73:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L75:
            if (r1 != j.m) goto L97;
            boolean r26 = v19.h.a;
            if (v19.h.b(r0) == true) goto L87;
            GenericDraweeHierarchy r27 = r7.getHierarchy();
            if (r27 == null) goto L81;
            r27.setPlaceholderImage(2131242949);
        L81:
            BlockContent r28 = r8.getContent();
            if (r28 == null) goto L86;
            LinkReaderBlock r29 = r28.getLinkReaderBlock();
            if (r29 == null) goto L86;
            r4 = r29.iconUrl;
        L86:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L87:
            GenericDraweeHierarchy r30 = r7.getHierarchy();
            if (r30 == null) goto L90;
            r30.setPlaceholderImage(2131242950);
        L90:
            BlockContent r31 = r8.getContent();
            if (r31 == null) goto L95;
            LinkReaderBlock r32 = r31.getLinkReaderBlock();
            if (r32 == null) goto L95;
            r4 = r32.iconUrlDark;
        L95:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L97:
            if (r1 != j.n) goto L119;
            boolean r33 = v19.h.a;
            if (v19.h.b(r0) == true) goto L109;
            GenericDraweeHierarchy r34 = r7.getHierarchy();
            if (r34 == null) goto L103;
            r34.setPlaceholderImage(2131242951);
        L103:
            BlockContent r35 = r8.getContent();
            if (r35 == null) goto L108;
            VideoReaderBlock r36 = r35.getVideoReaderBlock();
            if (r36 == null) goto L108;
            r4 = r36.iconUrl;
        L108:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L109:
            GenericDraweeHierarchy r37 = r7.getHierarchy();
            if (r37 == null) goto L112;
            r37.setPlaceholderImage(2131242952);
        L112:
            BlockContent r38 = r8.getContent();
            if (r38 == null) goto L117;
            VideoReaderBlock r39 = r38.getVideoReaderBlock();
            if (r39 == null) goto L117;
            r4 = r39.iconUrlDark;
        L117:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L119:
            if (r1 != j.o) goto L141;
            boolean r40 = v19.h.a;
            if (v19.h.b(r0) == true) goto L131;
            GenericDraweeHierarchy r41 = r7.getHierarchy();
            if (r41 == null) goto L125;
            r41.setPlaceholderImage(2131242937);
        L125:
            BlockContent r42 = r8.getContent();
            if (r42 == null) goto L130;
            CodeBlock r43 = r42.getCodeBlock();
            if (r43 == null) goto L130;
            r4 = r43.iconUrl;
        L130:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L131:
            GenericDraweeHierarchy r44 = r7.getHierarchy();
            if (r44 == null) goto L134;
            r44.setPlaceholderImage(2131242938);
        L134:
            BlockContent r45 = r8.getContent();
            if (r45 == null) goto L139;
            CodeBlock r46 = r45.getCodeBlock();
            if (r46 == null) goto L139;
            r4 = r46.iconUrlDark;
        L139:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L141:
            if (r1 != j.p) goto L163;
            boolean r47 = v19.h.a;
            if (v19.h.b(r0) == true) goto L153;
            GenericDraweeHierarchy r48 = r7.getHierarchy();
            if (r48 == null) goto L147;
            r48.setPlaceholderImage(2131242947);
        L147:
            BlockContent r49 = r8.getContent();
            if (r49 == null) goto L152;
            LocalLifeBlock r50 = r49.getLocalLifeBlock();
            if (r50 == null) goto L152;
            r4 = r50.iconUrl;
        L152:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L153:
            GenericDraweeHierarchy r51 = r7.getHierarchy();
            if (r51 == null) goto L156;
            r51.setPlaceholderImage(2131242948);
        L156:
            BlockContent r52 = r8.getContent();
            if (r52 == null) goto L161;
            LocalLifeBlock r53 = r52.getLocalLifeBlock();
            if (r53 == null) goto L161;
            r4 = r53.iconUrlDark;
        L161:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L163:
            if (r1 != j.q) goto L183;
            Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L180
            int r55 = AbsBlockView.a;     // Catch: Throwable -> L180
            GenImageBlock r56 = a(r8);     // Catch: Throwable -> L180
            boolean r57 = v19.h.a;     // Catch: Throwable -> L180
            if (v19.h.b(r0) == true) goto L172;
            GenericDraweeHierarchy r58 = r7.getHierarchy();     // Catch: Throwable -> L180
            if (r58 == null) goto L169;
            r58.setPlaceholderImage(2131242943);     // Catch: Throwable -> L180
        L169:
            if (r56 == null) goto L171;
            r4 = r56.iconUrl;     // Catch: Throwable -> L180
        L171:
            ImageLoaderKt.u(r7, r4, "deep_research");     // Catch: Throwable -> L180
        L178:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L180
            return;
        L172:
            GenericDraweeHierarchy r59 = r7.getHierarchy();     // Catch: Throwable -> L180
            if (r59 == null) goto L175;
            r59.setPlaceholderImage(2131242944);     // Catch: Throwable -> L180
        L175:
            if (r56 == null) goto L177;
            r4 = r56.iconUrlDark;     // Catch: Throwable -> L180
        L177:
            ImageLoaderKt.u(r7, r4, "deep_research");     // Catch: Throwable -> L180
        L180:
            th = move-exception;
            Result.Companion r60 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L183:
            if (r1 != j.s) goto L203;
            Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L200
            int r62 = AbsBlockView.a;     // Catch: Throwable -> L200
            ImageBlock r63 = b(r8);     // Catch: Throwable -> L200
            boolean r64 = v19.h.a;     // Catch: Throwable -> L200
            if (v19.h.b(r0) == true) goto L192;
            GenericDraweeHierarchy r65 = r7.getHierarchy();     // Catch: Throwable -> L200
            if (r65 == null) goto L189;
            r65.setPlaceholderImage(2131242943);     // Catch: Throwable -> L200
        L189:
            if (r63 == null) goto L191;
            r4 = r63.iconUrl;     // Catch: Throwable -> L200
        L191:
            ImageLoaderKt.u(r7, r4, "deep_research");     // Catch: Throwable -> L200
        L198:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L200
            return;
        L192:
            GenericDraweeHierarchy r66 = r7.getHierarchy();     // Catch: Throwable -> L200
            if (r66 == null) goto L195;
            r66.setPlaceholderImage(2131242944);     // Catch: Throwable -> L200
        L195:
            if (r63 == null) goto L197;
            r4 = r63.iconUrlDark;     // Catch: Throwable -> L200
        L197:
            ImageLoaderKt.u(r7, r4, "deep_research");     // Catch: Throwable -> L200
        L200:
            th = move-exception;
            Result.Companion r67 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L203:
            if (r1 != j.u) goto L219;
            boolean r68 = v19.h.a;
            if (v19.h.b(r0) == true) goto L212;
            BlockContent r69 = r8.getContent();
            if (r69 == null) goto L211;
            ResearchStatusBlock r70 = r69.getResearchStatusBlock();
            if (r70 == null) goto L211;
            r4 = r70.iconUrl;
        L211:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L212:
            BlockContent r71 = r8.getContent();
            if (r71 == null) goto L217;
            ResearchStatusBlock r72 = r71.getResearchStatusBlock();
            if (r72 == null) goto L217;
            r4 = r72.iconUrlDark;
        L217:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L219:
            if (r1 != j.x) goto L258;
            boolean r73 = v19.h.a;
            if (v19.h.b(r0) == true) goto L228;
            BlockContent r74 = r8.getContent();
            if (r74 == null) goto L227;
            RoutePlanBlock r75 = r74.getRoutePlanBlock();
            if (r75 == null) goto L227;
            r4 = r75.iconUrl;
        L227:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L228:
            BlockContent r76 = r8.getContent();
            if (r76 == null) goto L233;
            RoutePlanBlock r77 = r76.getRoutePlanBlock();
            if (r77 == null) goto L233;
            r4 = r77.iconUrlDark;
        L233:
            ImageLoaderKt.u(r7, r4, "deep_research");
            return;
        L258:
            return;
        L260:
            return;
        }

        public static String f(Block r10, boolean r11, boolean r12) {
            if (r10 == null) goto L5;
            Integer r1 = Integer.valueOf(r10.getBlockType());
        L6:
            int r2 = j.e;
            if (r1 != null) goto L10;
        L13:
            int r3 = j.q;
            if (r1 != null) goto L17;
        L27:
            int r4 = j.s;
            if (r1 != null) goto L31;
        L43:
            int r5 = j.p;
            if (r1 != null) goto L47;
        L55:
            int r6 = j.n;
            if (r1 != null) goto L59;
        L67:
            int r7 = j.o;
            if (r1 != null) goto L71;
        L87:
            int r13 = j.u;
            String r8 = "";
            if (r1 != null) goto L91;
        L100:
            int r14 = j.i;
            if (r1 != null) goto L104;
        L112:
            int r15 = j.k;
            if (r1 != null) goto L116;
        L128:
            int r16 = j.m;
            if (r1 != null) goto L132;
        L158:
            int r17 = j.x;
            if (r1 != null) goto L162;
            return null;
        L162:
            if (r1.intValue() != r17) goto L198;
            if (r10 == null) goto L199;
            BlockContent r18 = r10.getContent();
            if (r18 == null) goto L200;
            RoutePlanBlock r19 = r18.getRoutePlanBlock();
            if (r19 != null) goto L169;
            return null;
        L169:
            return r19.summary;
        L200:
            return null;
        L199:
            return null;
        L198:
            return null;
        L132:
            if (r1.intValue() != r16) goto L158;
            BlockContent r110 = r10.getContent();
            if (r110 == null) goto L140;
            LinkReaderBlock r111 = r110.getLinkReaderBlock();
            if (r111 == null) goto L140;
            List r112 = r111.items;
            if (r112 == null) goto L140;
            TextCard r113 = (TextCard) CollectionsKt.firstOrNull(r112);
        L141:
            if (r113 != null) goto L148;
            BlockContent r114 = r10.getContent();
            if (r114 == null) goto L196;
            LinkReaderBlock r115 = r114.getLinkReaderBlock();
            if (r115 != null) goto L147;
            return null;
        L147:
            return r115.summary;
        L196:
            return null;
        L148:
            StringCompanionObject r116 = StringCompanionObject.INSTANCE;
            BlockContent r117 = r10.getContent();
            if (r117 == null) goto L157;
            LinkReaderBlock r118 = r117.getLinkReaderBlock();
            if (r118 == null) goto L157;
            String r119 = r118.summary;
            if (r119 == null) goto L157;
            r8 = r119;
        L157:
            return String.format(r8, Arrays.copyOf(new Object[]{r113}, 1));
        L140:
            r113 = null;
            goto L141
        L116:
            if (r1.intValue() != r15) goto L128;
            if (r10.isFinish() == true) goto L120;
            return "";
        L120:
            BlockContent r120 = r10.getContent();
            if (r120 == null) goto L193;
            SearchQueryBlock r121 = r120.getSearchQueryBlock();
            if (r121 == null) goto L194;
            List r122 = r121.queries;
            if (r122 != null) goto L127;
            return null;
        L127:
            return CollectionsKt.joinToString$default(r122, "、", null, null, 0, null, new com.larus.bmhome.chat.deepresearch.view.a(), 30, null);
        L194:
            return null;
        L193:
            return null;
        L104:
            if (r1.intValue() != r14) goto L112;
            if (r10 == null) goto L190;
            BlockContent r123 = r10.getContent();
            if (r123 == null) goto L191;
            BannerBlock r124 = r123.getBannerBlock();
            if (r124 != null) goto L111;
            return null;
        L111:
            return r124.summary;
        L191:
            return null;
        L190:
            return null;
        L91:
            if (r1.intValue() != r13) goto L100;
            if (r11 == true) goto L94;
            return "";
        L94:
            BlockContent r125 = r10.getContent();
            if (r125 == null) goto L188;
            ResearchStatusBlock r126 = r125.getResearchStatusBlock();
            if (r126 != null) goto L99;
            return null;
        L99:
            return r126.summary;
        L188:
            return null;
        L71:
            if (r1.intValue() != r7) goto L87;
            if (r12 == false) goto L80;
            if (r10 == null) goto L182;
            BlockContent r127 = r10.getContent();
            if (r127 == null) goto L183;
            CodeBlock r128 = r127.getCodeBlock();
            if (r128 != null) goto L79;
            return null;
        L79:
            return r128.code;
        L183:
            return null;
        L182:
            return null;
        L80:
            if (r10 == null) goto L185;
            BlockContent r129 = r10.getContent();
            if (r129 == null) goto L186;
            CodeBlock r130 = r129.getCodeBlock();
            if (r130 != null) goto L86;
            return null;
        L86:
            return r130.summary;
        L186:
            return null;
        L185:
            return null;
        L59:
            if (r1.intValue() != r6) goto L67;
            if (r10 == null) goto L179;
            BlockContent r131 = r10.getContent();
            if (r131 == null) goto L180;
            VideoReaderBlock r132 = r131.getVideoReaderBlock();
            if (r132 != null) goto L66;
            return null;
        L66:
            return r132.summary;
        L180:
            return null;
        L179:
            return null;
        L47:
            if (r1.intValue() != r5) goto L55;
            if (r10 == null) goto L176;
            BlockContent r133 = r10.getContent();
            if (r133 == null) goto L177;
            LocalLifeBlock r134 = r133.getLocalLifeBlock();
            if (r134 != null) goto L54;
            return null;
        L54:
            return r134.summary;
        L177:
            return null;
        L176:
            return null;
        L31:
            if (r1.intValue() != r4) goto L43;
            Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L40
            Gson r136 = new Gson();     // Catch: Throwable -> L40
            if (r10 == null) goto L37;
            BlockContent r137 = r10.getContent();     // Catch: Throwable -> L40
            if (r137 == null) goto L37;
            String r138 = r137.getImageBlock();     // Catch: Throwable -> L40
        L38:
            return ((ImageBlock) r136.fromJson(r138, ImageBlock.class)).summary;
        L37:
            r138 = null;
        L40:
            th = move-exception;
            Result.Companion r139 = Result.Companion;
            Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            return null;
        L17:
            if (r1.intValue() != r3) goto L27;
            Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L24
            BlockContent r141 = r10.getContent();     // Catch: Throwable -> L24
            if (r141 == null) goto L174;
            GenImageBlock r142 = r141.getGenImageBlock();     // Catch: Throwable -> L24
            if (r142 == null) goto L175;
            return r142.summary;
        L175:
            return null;
        L174:
            return null;
        L24:
            th = move-exception;
            Result.Companion r143 = Result.Companion;
            Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            return null;
        L10:
            if (r1.intValue() != r2) goto L13;
            return qf8.a.c(r10, null, 3);
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    public abstract void a(Block r1, Map<String, Object> r2);

    public abstract void b(Context r1, AttributeSet r2);

    public void c() {
    }

    public AbsBlockView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        b(r2, null);
    }

    public AbsBlockView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        b(r2, r3);
    }

    public AbsBlockView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        b(r2, r3);
    }
}
