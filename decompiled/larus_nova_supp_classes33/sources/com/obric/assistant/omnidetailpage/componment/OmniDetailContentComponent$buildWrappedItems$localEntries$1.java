package com.obric.assistant.omnidetailpage.componment;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.LocalImageMeta;
import com.larus.im.bean.message.LocalVideoData;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.ClickActionType;
import com.larus.im.bean.message.block.InconImg;
import com.larus.im.bean.message.block.LocalFileBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/omnidetailpage/model/LocalResultEntry;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$buildWrappedItems$localEntries$1", f = "OmniDetailContentComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OmniDetailContentComponent$buildWrappedItems$localEntries$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ifa.d>>, Object> {
    final /* synthetic */ List<Block> $blocks;
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$buildWrappedItems$localEntries$1(OmniDetailContentComponent r1, List<Block> r2, Continuation<? super OmniDetailContentComponent$buildWrappedItems$localEntries$1> r3) {
        this.this$0 = r1;
        this.$blocks = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OmniDetailContentComponent$buildWrappedItems$localEntries$1(this.this$0, this.$blocks, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends ifa.d>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r31) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L232;
        ResultKt.throwOnFailure(r31);
        OmniDetailContentComponent r1 = this.this$0;
        List<Block> r2 = this.$blocks;
        int r3 = OmniDetailContentComponent.I;
        r1.getClass();
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L230;
        Block r6 = (Block) r5.next();
        int r7 = r6.getBlockType();
        if (r7 != BlockType.BLOCK_TYPE_LOCAL_FILE.getValue()) goto L71;
        com.obric.assistant.omnidetailpage.localmedia.l r8 = com.obric.assistant.omnidetailpage.localmedia.l.a;
        String r9 = r6.getBlockId();
        BlockContent r11 = r6.getContent();
        if (r11 == null) goto L12;
        LocalFileBlock r12 = r11.getLocalFileBlock();
    L13:
        r8.getClass();
        if (r12 == null) goto L22;
        String r10 = r12.path;
        if (r10 != null) goto L19;
        r10 = r12.uri;
    L19:
        String r13 = com.obric.assistant.omnidetailpage.localmedia.l.b(r10);
        if (r13 != null) goto L23;
        com.obric.assistant.omnidetailpage.localmedia.l.a(r9, "local_file", "unreadable_path");
        goto L22
    L23:
        String r14 = r12.name;
        if (r14 != null) goto L26;
    L30:
        r14 = new PolarisFileWrapper(r13).getName();
    L31:
        String r15 = r14;
        if (r9 != null) goto L34;
    L40:
        String r16 = r13;
    L41:
        Intrinsics.checkNotNull(r15);
        String r17 = r12.type;
        if (r17 != null) goto L44;
        String r18 = "";
    L45:
        String r19 = com.obric.assistant.omnidetailpage.localmedia.l.c(r13);
        InconImg r20 = r12.icon;
        if (r20 == null) goto L48;
        String r110 = r20.iconUrl;
    L49:
        if (r110 != null) goto L51;
        String r111 = "";
    L52:
        if (r20 == null) goto L54;
        String r21 = r20.iconUrlDark;
    L55:
        if (r21 != null) goto L57;
        String r112 = "";
    L58:
        Integer r22 = r12.clickActionType;
        int r23 = ClickActionType.CLICK_ACTION_TYPE_PLAY_AUDIO_BUTTON.getValue();
        if (r22 != null) goto L62;
    L64:
        boolean r24 = false;
    L65:
        ifa.b r25 = new ifa.b(r16, r15, r18, r13, r19, r111, r112, r24);
    L66:
        if (r25 == null) goto L68;
        ifa.d.a r26 = new ifa.d.a(r6, r25);
    L69:
        List r27 = CollectionsKt.listOfNotNull(r26);
        ArrayList r113 = r4;
    L228:
        CollectionsKt.addAll(r113, r27);
        r4 = r113;
        goto L6
    L68:
        r26 = null;
        goto L69
    L62:
        if (r22.intValue() != r23) goto L64;
        r24 = true;
        goto L65
    L57:
        r112 = r21;
        goto L58
    L54:
        r21 = null;
        goto L55
    L51:
        r111 = r110;
        goto L52
    L48:
        r110 = null;
        goto L49
    L44:
        r18 = r17;
        goto L45
    L34:
        if ((!StringsKt.isBlank(r9)) == true) goto L37;
        r9 = null;
    L37:
        if (r9 == null) goto L40;
        r16 = r9;
        goto L41
    L26:
        if ((!StringsKt.isBlank(r14)) == true) goto L29;
        r14 = null;
    L29:
        if (r14 != null) goto L31;
    L22:
        r25 = null;
        goto L66
    L12:
        r12 = null;
        goto L13
    L71:
        if (r7 != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L227;
        BlockContent r28 = r6.getContent();
        if (r28 == null) goto L77;
        CreationBlock r29 = r28.getCreationBlock();
        if (r29 == null) goto L77;
        List r30 = r29.creations;
    L78:
        if (r30 != null) goto L80;
        r30 = CollectionsKt.emptyList();
    L80:
        ArrayList r32 = new ArrayList();
        Iterator r33 = r30.iterator();
    L82:
        if (r33.hasNext() == false) goto L226;
        CreationItem r114 = (CreationItem) r33.next();
        ifa.d.b[] r115 = new ifa.d.b[2];
        com.obric.assistant.omnidetailpage.localmedia.l r116 = com.obric.assistant.omnidetailpage.localmedia.l.a;
        String r117 = r6.getBlockId();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r114, "item");
        Integer r34 = r114.type;
        if (r34 != null) goto L87;
    L110:
        r4 = r4;
        ifa.c.a r0 = null;
    L137:
        if (r0 == null) goto L139;
        ifa.d.b r35 = new ifa.d.b(r6, r0);
        char r36 = 0;
    L140:
        r115[r36] = r35;
        String r37 = r6.getBlockId();
        Intrinsics.checkNotNullParameter(r114, "item");
        Integer r38 = r114.type;
        if (r38 != null) goto L144;
    L165:
        ifa.c.b r39 = null;
    L222:
        if (r39 == null) goto L224;
        ifa.d.b r40 = new ifa.d.b(r6, r39);
    L225:
        r115[1] = r40;
        CollectionsKt.addAll(r32, CollectionsKt.listOfNotNull(r115));
        r4 = r4;
        goto L82
    L224:
        r40 = null;
        goto L225
    L144:
        if (r38.intValue() != 4) goto L165;
        LocalVideoData r41 = r114.localVideo;
        if (r41 == null) goto L165;
        Integer r42 = r41.status;
        if (r42 != null) goto L152;
    L155:
        boolean r43 = true;
    L157:
        if (r43 == true) goto L159;
        com.obric.assistant.omnidetailpage.localmedia.l.a(r37, "local_video", "status_not_succeed");
        goto L165
    L159:
        String r44 = r41.videoPath;
        if (r44 != null) goto L162;
        r44 = r41.uri;
    L162:
        String r210 = com.obric.assistant.omnidetailpage.localmedia.l.b(r44);
        if (r210 != null) goto L166;
        com.obric.assistant.omnidetailpage.localmedia.l.a(r37, "local_video", "unreadable_path");
        goto L165
    L166:
        Cover r45 = r41.cover;
        if (r45 == null) goto L171;
        LocalImageMeta r46 = r45.localImagePreview;
        if (r46 == null) goto L171;
        String r47 = r46.path;
    L172:
        String r48 = com.obric.assistant.omnidetailpage.localmedia.l.b(r47);
        if (r48 != null) goto L179;
        Cover r49 = r41.cover;
        if (r49 == null) goto L177;
        String r50 = r49.key;
    L178:
        r48 = com.obric.assistant.omnidetailpage.localmedia.l.b(r50);
        goto L179
    L177:
        r50 = null;
    L179:
        String r211 = r48;
        String r51 = r114.id;
        if (r51 != null) goto L182;
    L186:
        r51 = r41.vid;
        if (r51 != null) goto L189;
        String r118 = r210;
    L190:
        if (r37 != null) goto L192;
        String r212 = "";
    L193:
        String r213 = com.obric.assistant.omnidetailpage.localmedia.l.c(r210);
        if (r211 == null) goto L196;
        String r214 = com.obric.assistant.omnidetailpage.localmedia.l.c(r211);
    L197:
        Cover r52 = r41.cover;
        if (r52 == null) goto L204;
        LocalImageMeta r53 = r52.localImagePreview;
        if (r53 == null) goto L204;
        Long r54 = r53.width;
        if (r54 == null) goto L204;
        Integer r215 = Integer.valueOf((int) r54.longValue());
    L205:
        Cover r55 = r41.cover;
        if (r55 == null) goto L212;
        LocalImageMeta r56 = r55.localImagePreview;
        if (r56 == null) goto L212;
        Long r57 = r56.height;
        if (r57 == null) goto L212;
        Integer r216 = Integer.valueOf((int) r57.longValue());
    L213:
        Long r58 = r41.width;
        if (r58 == null) goto L216;
        Integer r217 = Integer.valueOf((int) r58.longValue());
    L217:
        Long r59 = r41.height;
        if (r59 == null) goto L220;
        Integer r218 = Integer.valueOf((int) r59.longValue());
    L221:
        r39 = new ifa.c.b(r118, r212, r210, r213, r211, r214, r215, r216, r217, r218, r41.duration);
        goto L222
    L220:
        r218 = null;
        goto L221
    L216:
        r217 = null;
    L212:
        r216 = null;
    L204:
        r215 = null;
        goto L205
    L196:
        r214 = null;
        goto L197
    L192:
        r212 = r37;
    L189:
        r118 = r51;
        goto L190
    L182:
        if ((!StringsKt.isBlank(r51)) == true) goto L185;
        r51 = null;
    L185:
        if (r51 != null) goto L189;
    L171:
        r47 = null;
        goto L172
    L152:
        if (r42.intValue() == 3) goto L155;
        r43 = false;
        goto L157
    L139:
        r36 = 0;
        r35 = null;
        goto L140
    L87:
        if (r34.intValue() != 3) goto L110;
        LocalImageData r60 = r114.localImage;
        if (r60 == null) goto L110;
        Integer r61 = r60.status;
        if (r61 != null) goto L95;
    L98:
        boolean r62 = true;
    L100:
        if (r62 == true) goto L102;
        com.obric.assistant.omnidetailpage.localmedia.l.a(r117, "local_image", "status_not_succeed");
        goto L110
    L102:
        LocalImageMeta r63 = r60.localImageOriRaw;
        if (r63 == null) goto L106;
        String r64 = r63.path;
        if (r64 == null) goto L106;
    L107:
        String r219 = com.obric.assistant.omnidetailpage.localmedia.l.b(r64);
        if (r219 != null) goto L111;
        com.obric.assistant.omnidetailpage.localmedia.l.a(r117, "local_image", "unreadable_path");
        goto L110
    L111:
        String r65 = r114.id;
        if (r65 != null) goto L114;
    L120:
        String r220 = r219;
    L121:
        if (r117 != null) goto L123;
        String r221 = "";
    L124:
        String r222 = com.obric.assistant.omnidetailpage.localmedia.l.c(r219);
        LocalImageMeta r66 = r60.localImageOriRaw;
        if (r66 == null) goto L129;
        Long r67 = r66.width;
        if (r67 == null) goto L129;
        Integer r223 = Integer.valueOf((int) r67.longValue());
    L130:
        LocalImageMeta r68 = r60.localImageOriRaw;
        if (r68 == null) goto L135;
        Long r69 = r68.height;
        if (r69 == null) goto L135;
        Integer r224 = Integer.valueOf((int) r69.longValue());
    L136:
        r0 = new ifa.c.a(r220, r221, r219, r222, r223, r224);
    L135:
        r224 = null;
    L129:
        r223 = null;
        goto L130
    L123:
        r221 = r117;
        goto L124
    L114:
        if ((!StringsKt.isBlank(r65)) == true) goto L117;
        r65 = null;
    L117:
        if (r65 == null) goto L120;
        r220 = r65;
    L106:
        r64 = r60.uri;
        goto L107
    L95:
        if (r61.intValue() == 2) goto L98;
        r62 = false;
        goto L100
    L226:
        r113 = r4;
        r27 = r32;
    L77:
        r30 = null;
        goto L78
    L227:
        r113 = r4;
        r27 = CollectionsKt.emptyList();
        goto L228
    L230:
        return r4;
    L232:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
