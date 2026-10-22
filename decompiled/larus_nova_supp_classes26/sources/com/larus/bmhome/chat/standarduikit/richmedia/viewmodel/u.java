package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaItemAction;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.GenericImageItem;
import com.larus.im.bean.message.block.GenericVideoItem;
import com.larus.im.bean.message.block.MediaType;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaLayoutBlock;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.im.bean.message.block.SearchVideoItem;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.OuterFallbackInfo;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kc8.s0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public static final Set<Integer> i = null;
    public final Message a;
    public final String b;
    public final int c;
    public final List<RichMediaItem> d;
    public final f0 e;
    public final List<fn8.c> f;
    public final y g;
    public final w h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[RichMediaKind.values().length];
            r0[RichMediaKind.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[RichMediaKind.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L6:
            a = r0;
            int[] r1 = new int[RichMediaItemAction.values().length];
            r1[RichMediaItemAction.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L37:
            r1[RichMediaItemAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L29:
            r1[RichMediaItemAction.IMAGE_EDIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r1[RichMediaItemAction.VIDEO_EDIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L23:
            r1[RichMediaItemAction.CITE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L33:
            r1[RichMediaItemAction.EXTEND.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L13:
            b = r1;
        }
    }

    static {
        i = SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_IMAGE.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_GEN_IMAGE.getValue())});
    }

    public static boolean e() {
        if (AccountService.a.isEnterpriseAccount() == false) goto L5;
    L7:
        return false;
    L5:
        if (SettingRepoDelegate.b.q0() == false) goto L7;
        return true;
    }

    public final List<CreationItem> b() {
        List<RichMediaItem> r0 = d(new s());
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        CreationItem r3 = ((RichMediaItem) r2.next()).creation;
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public final boolean h() {
        f0 r0 = this.e;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    public final void m() {
        List<fn8.c> r0 = this.f;
        final ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        fn8.b r3 = ((fn8.c) r2.next()).h;
        SearchVideoItem r4 = null;
        if ((r3 instanceof fn8.b.e) == false) goto L8;
        fn8.b.e r5 = (fn8.b.e) r3;
    L9:
        if (r5 == null) goto L11;
        r4 = r5.a;
    L11:
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L8:
        r5 = null;
        goto L9
    L14:
        if (r1.isEmpty() == false) goto L16;
        return;
    L16:
        t0.a(new r(this, r1));
    }

    public final String n() {
        Map r0 = this.a.getExt();
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("rich_media_type");
        if (r1 == null) goto L7;
        return r1;
    L7:
        List<RichMediaItem> r2 = d(new i());
        boolean r3 = true;
        if ((!r2.isEmpty()) == false) goto L28;
        List<RichMediaItem> r4 = r2;
        if ((r4 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r5 = r4.iterator();
    L16:
        if (r5.hasNext() == false) goto L26;
        Integer r6 = ((RichMediaItem) r5.next()).type;
        int r7 = RichMediaType.SEARCH_IMAGE.getValue();
        if (r6 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == true) goto L16;
        r3 = false;
        goto L26
    L21:
        if (r6.intValue() != r7) goto L23;
        r8 = true;
    L26:
        if (r3 == false) goto L28;
        return "only_picture";
    L12:
        if (r4.isEmpty() == false) goto L14;
    L28:
        return "mixed_picture";
    }

    public final List<CreationItem> a() {
        List<CreationItem> r0 = b();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L46;
        Object r3 = r2.next();
        CreationItem r4 = (CreationItem) r3;
        Integer r5 = r4.type;
        boolean r6 = false;
        if (r5 != null) goto L9;
    L18:
        if (r5 != null) goto L21;
    L44:
        if (r6 == false) goto L4;
        r1.add(r3);
        goto L4
    L21:
        if (r5.intValue() != 2) goto L44;
        VideoData r7 = r4.video;
        if (r7 == null) goto L30;
        Integer r8 = r7.status;
        if (r8 == null) goto L30;
        if (r8.intValue() != 3) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L44;
        VideoData r10 = r4.video;
        if (r10 == null) goto L35;
        String r11 = r10.vid;
    L36:
        if (r11 != null) goto L38;
    L41:
        boolean r12 = true;
    L42:
        if (r12 == true) goto L44;
    L43:
        r6 = true;
        goto L44
    L38:
        if (r11.length() == 0) goto L41;
        r12 = false;
        goto L42
    L35:
        r11 = null;
    L30:
        r9 = false;
        goto L31
    L9:
        if (r5.intValue() != 1) goto L18;
        ImageData r13 = r4.image;
        if (r13 == null) goto L44;
        Integer r14 = r13.status;
        if (r14 == null) goto L44;
        if (r14.intValue() != 2) goto L44;
    L46:
        return r1;
    }

    public static boolean i(RichMediaItem r5) {
        Integer r0 = r5.type;
        int r1 = RichMediaType.SEARCH_IMAGE.getValue();
        if (r0 != null) goto L6;
    L46:
        int r2 = RichMediaType.GENERIC_IMAGE.getValue();
        if (r0 != null) goto L50;
        return false;
    L50:
        if (r0.intValue() != r2) goto L72;
        GenericImageItem r6 = r5.imageItem;
        if (r6 != null) goto L54;
        return false;
    L54:
        if (r6.type == MediaType.MediaTypeLocalFile.getValue()) goto L63;
        String r7 = r6.resource;
        if (r7 != null) goto L58;
    L60:
        boolean r8 = false;
    L61:
        if (r8 == false) goto L63;
        boolean r9 = true;
    L64:
        if (r9 != true) goto L74;
    L65:
        return true;
    L74:
        return false;
    L58:
        if ((!StringsKt.isBlank(r7)) != true) goto L60;
        r8 = true;
    L63:
        r9 = false;
        goto L64
    L72:
        return false;
    L6:
        if (r0.intValue() != r1) goto L46;
        SearchImageItem r10 = r5.image;
        if (r10 == null) goto L70;
        String r3 = r10.originThumbUrl;
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L43;
        String r11 = r10.thumbUrl;
        if (r11 != null) goto L19;
    L21:
        boolean r12 = false;
    L22:
        if (r12 == true) goto L43;
        List r13 = r10.fullSizeUrl;
        if (r13 == null) goto L39;
        List r14 = r13;
        if ((r14 instanceof Collection) == true) goto L28;
    L30:
        Iterator r15 = r14.iterator();
    L32:
        if (r15.hasNext() == false) goto L36;
        if ((!StringsKt.isBlank((String) r15.next())) == false) goto L32;
        boolean r16 = true;
    L37:
        if (r16 != true) goto L39;
        boolean r17 = true;
    L40:
        if (r17 == true) goto L43;
        boolean r18 = false;
    L44:
        if (r18 == true) goto L65;
        return false;
    L36:
        r16 = false;
        goto L37
    L28:
        if (r14.isEmpty() == false) goto L30;
    L39:
        r17 = false;
        goto L40
    L19:
        if ((!StringsKt.isBlank(r11)) != true) goto L21;
        r12 = true;
    L43:
        r18 = true;
        goto L44
    L12:
        if ((!StringsKt.isBlank(r3)) != true) goto L14;
        r4 = true;
        goto L15
    L70:
        return false;
    }

    public static MediaEntity o(SearchVideoItem r29) {
        return new MediaEntity(null, r29.itemId, null, null, null, null, null, null, null, null, null, null, r29.sourceFrom, null, null, null, 0, null, null, null, null, null, null, null, 16773117, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.ArrayList] */
    public final List<RichMediaItem> d(Function1<? super RichMediaItem, Boolean> r7) {
        List r0 = com.larus.im.bean.message.a.d(this.a);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L21;
        Block r3 = (Block) r2.next();
        BlockContent r4 = r3.getContent();
        if (r4 == null) goto L8;
        RichMediaLayoutBlock r5 = r4.getRichMediaLayoutBlock();
    L10:
        if (r3.getBlockType() != BlockType.BLOCK_TYPE_RICH_MEDIA_LAYOUT.getValue()) goto L18;
        if (r5 == null) goto L18;
        List r6 = r5.richMediaItem;
        ?? r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L14:
        if (r9.hasNext() == false) goto L19;
        Object r10 = r9.next();
        if (((Boolean) r7.invoke(r10)).booleanValue() == false) goto L14;
        r8.add(r10);
    L19:
        CollectionsKt.addAll(r1, (Iterable) r8);
    L18:
        r8 = CollectionsKt.emptyList();
        goto L19
    L8:
        r5 = null;
        goto L10
    L21:
        if (r1.isEmpty() == false) goto L28;
        List<RichMediaItem> r11 = this.d;
        r1 = new ArrayList();
        Iterator r12 = r11.iterator();
    L24:
        if (r12.hasNext() == false) goto L28;
        Object r13 = r12.next();
        if (((Boolean) r7.invoke(r13)).booleanValue() == false) goto L24;
        r1.add(r13);
    L28:
        return r1;
    }

    public final int f(CreationItem r6) {
        int r0 = ((ArrayList) b()).indexOf(r6);
        if (r0 < 0) goto L5;
        return r0;
    L5:
        List<fn8.c> r1 = this.f;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L17;
        fn8.b r4 = ((fn8.c) r3.next()).h;
        CreationItem r5 = null;
        if ((r4 instanceof fn8.b.a) == false) goto L11;
        fn8.b.a r7 = (fn8.b.a) r4;
    L12:
        if (r7 == null) goto L14;
        r5 = r7.a;
    L14:
        if (r5 == null) goto L7;
        r2.add(r5);
        goto L7
    L11:
        r7 = null;
        goto L12
    L17:
        return RangesKt.coerceAtLeast(r2.indexOf(r6), 0);
    }

    public final JSONObject p(fn8.c r5) {
        Message r0 = this.a;
        String r1 = this.b;
        int r2 = this.f.indexOf(r5);
        int r3 = 1;
        if (r2 < 0) goto L6;
        r3 = 1 + r2;
    L6:
        return j0.b(r5, r0, r1, r3).b();
    }

    public static boolean j(RichMediaItem r5, fn8.c r6) {
        fn8.b r7 = r6.h;
        Object r2 = null;
        if ((r7 instanceof fn8.b.d) == false) goto L16;
        Integer r0 = r5.type;
        int r4 = RichMediaType.SEARCH_IMAGE.getValue();
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.intValue() != r4) goto L94;
        SearchImageItem r8 = r5.image;
        if (r8 == null) goto L13;
        r2 = r8.id;
    L13:
        if (Intrinsics.areEqual(r2, ((fn8.b.d) r7).a.id) == false) goto L95;
    L86:
        return true;
    L95:
        return false;
    L94:
        return false;
    L16:
        if ((r7 instanceof fn8.b.C0108b) == false) goto L52;
        Integer r1 = r5.type;
        int r9 = RichMediaType.GENERIC_IMAGE.getValue();
        if (r1 != null) goto L21;
        return false;
    L21:
        if (r1.intValue() != r9) goto L96;
        GenericImageItem r10 = r5.imageItem;
        if (r10 == null) goto L48;
        GenericImageItem r11 = ((fn8.b.C0108b) r7).a;
        if (Intrinsics.areEqual(r10, r11) == false) goto L27;
        boolean r12 = true;
    L46:
        if (r12 != true) goto L48;
        boolean r13 = true;
    L49:
        if (r13 == true) goto L86;
        return false;
    L27:
        String r3 = r10.id;
        if (r3 == null) goto L30;
        r12 = Intrinsics.areEqual(r3, r11.id);
        goto L46
    L30:
        String r14 = r10.uri;
        if (r14 != null) goto L33;
    L38:
        String r15 = r10.resource;
        if (r15 != null) goto L41;
    L45:
        r12 = false;
        goto L46
    L41:
        if ((!StringsKt.isBlank(r15)) == false) goto L43;
        r2 = r15;
    L43:
        if (r2 == null) goto L45;
        r12 = Intrinsics.areEqual(r2, r11.resource);
        goto L46
    L33:
        if ((!StringsKt.isBlank(r14)) == true) goto L36;
        r14 = null;
    L36:
        if (r14 == null) goto L38;
        r12 = Intrinsics.areEqual(r14, r11.uri);
    L48:
        r13 = false;
        goto L49
    L96:
        return false;
    L52:
        if ((r7 instanceof fn8.b.c) == false) goto L88;
        Integer r16 = r5.type;
        int r17 = RichMediaType.GENERIC_VIDEO.getValue();
        if (r16 != null) goto L57;
        return false;
    L57:
        if (r16.intValue() != r17) goto L98;
        GenericVideoItem r18 = r5.videoItem;
        if (r18 == null) goto L84;
        GenericVideoItem r19 = ((fn8.b.c) r7).a;
        if (Intrinsics.areEqual(r18, r19) == false) goto L63;
        boolean r20 = true;
    L82:
        if (r20 != true) goto L84;
        boolean r21 = true;
    L85:
        if (r21 == true) goto L86;
        return false;
    L63:
        String r22 = r18.id;
        if (r22 == null) goto L66;
        r20 = Intrinsics.areEqual(r22, r19.id);
        goto L82
    L66:
        String r23 = r18.uri;
        if (r23 != null) goto L69;
    L74:
        String r24 = r18.resource;
        if (r24 != null) goto L77;
    L81:
        r20 = false;
        goto L82
    L77:
        if ((!StringsKt.isBlank(r24)) == false) goto L79;
        r2 = r24;
    L79:
        if (r2 == null) goto L81;
        r20 = Intrinsics.areEqual(r2, r19.resource);
        goto L82
    L69:
        if ((!StringsKt.isBlank(r23)) == true) goto L72;
        r23 = null;
    L72:
        if (r23 == null) goto L74;
        r20 = Intrinsics.areEqual(r23, r19.uri);
    L84:
        r21 = false;
        goto L85
    L98:
        return false;
    L88:
        if ((r7 instanceof fn8.b.e) == false) goto L90;
        return false;
    L90:
        if ((r7 instanceof fn8.b.a) == false) goto L93;
        return false;
    L93:
        throw new NoWhenBranchMatchedException();
    }

    public final Message c(boolean r197, Function1<? super RichMediaItem, Boolean> r198) {
        Message r2 = this.a;
        ArrayList r8 = new ArrayList();
        List r3 = com.larus.im.bean.message.a.d(r2);
        ArrayList r6 = new ArrayList();
        Iterator r4 = r3.iterator();
        int r47 = 0;
        boolean r5 = false;
        int r7 = 0;
    L4:
        if (r4.hasNext() == false) goto L70;
        Block r16 = (Block) r4.next();
        BlockContent r48 = r16.getContent();
        if (r48 == null) goto L8;
        RichMediaLayoutBlock r9 = r48.getRichMediaLayoutBlock();
    L9:
        int r10 = r16.getBlockType();
        BlockType r11 = BlockType.BLOCK_TYPE_RICH_MEDIA_LAYOUT;
        if (r10 != r11.getValue()) goto L13;
        r7 = r7 + 1;
    L13:
        if (r16.getBlockType() != r11.getValue()) goto L56;
        if (r9 == null) goto L56;
        if (r197 == false) goto L17;
    L36:
        List r12 = r9.richMediaItem;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
        int r15 = 0;
    L38:
        if (r14.hasNext() == false) goto L53;
        Object r17 = r14.next();
        int r18 = r15 + 1;
        if (r15 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        RichMediaItem r19 = (RichMediaItem) r17;
        if (((Boolean) r198.invoke(r19)).booleanValue() == true) goto L46;
        r19 = null;
    L46:
        if (r19 == null) goto L48;
        StringBuilder r110 = new StringBuilder();
        r110.append(r7);
        r110.append(':');
        r110.append(r18);
        r8.add(r110.toString());
    L49:
        if (r19 == null) goto L51;
        r13.add(r19);
    L51:
        r15 = r18;
        goto L38
    L48:
        r19 = null;
        goto L49
    L53:
        if (r13.isEmpty() == false) goto L55;
        Block r111 = null;
    L68:
        if (r111 == null) goto L4;
        r6.add(r111);
        goto L4
    L55:
        r111 = Block.copy$default(r16, 0, null, null, BlockContent.copy$default(r48, null, null, RichMediaLayoutBlock.copy$default(r9, r13, null, 2, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -5, -1, 31, null), false, null, null, null, 247, null);
        r5 = true;
        goto L68
    L17:
        if (r16.getBlockType() == r11.getValue()) goto L19;
        boolean r20 = false;
    L35:
        if (r20 == false) goto L56;
    L19:
        String r21 = this.b;
        if (r21 != null) goto L22;
    L25:
        boolean r22 = true;
    L26:
        if (r22 == true) goto L28;
        r20 = Intrinsics.areEqual(r16.getBlockId(), this.b);
        goto L35
    L28:
        BlockContent r23 = r16.getContent();
        if (r23 == null) goto L33;
        RichMediaLayoutBlock r24 = r23.getRichMediaLayoutBlock();
        if (r24 == null) goto L33;
        List r25 = r24.richMediaItem;
    L34:
        r20 = Intrinsics.areEqual(r25, this.d);
    L33:
        r25 = null;
        goto L34
    L22:
        if (r21.length() == 0) goto L25;
        r22 = false;
    L56:
        r111 = null;
        if (r16.getBlockType() != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L59;
    L64:
        boolean r112 = true;
    L65:
        if (r112 == true) goto L68;
        r111 = r16;
        goto L68
    L59:
        if (i.contains(Integer.valueOf(r16.getBlockType())) == true) goto L64;
        if (r16.getBlockType() == r11.getValue()) goto L64;
        r112 = false;
        goto L65
    L8:
        r9 = null;
        goto L9
    L70:
        Message r113 = null;
        if (r5 == true) goto L73;
        Object r122 = "_mixed_richmedia_position_trace";
    L77:
        if (r113 != null) goto L113;
        Message r26 = this.a;
        ArrayList r27 = new ArrayList();
        List<RichMediaItem> r28 = this.d;
        ArrayList r114 = new ArrayList();
        Iterator<T> r29 = r28.iterator();
    L80:
        if (r29.hasNext() == false) goto L95;
        Object r30 = r29.next();
        int r31 = r47 + 1;
        if (r47 >= 0) goto L84;
        CollectionsKt.throwIndexOverflow();
    L84:
        RichMediaItem r115 = (RichMediaItem) r30;
        if (((Boolean) r198.invoke(r115)).booleanValue() == true) goto L88;
        r115 = null;
    L88:
        if (r115 == null) goto L90;
        StringBuilder r32 = new StringBuilder();
        r32.append(this.c);
        r32.append(':');
        r32.append(r31);
        r27.add(r32.toString());
    L91:
        if (r115 == null) goto L93;
        r114.add(r115);
    L93:
        r47 = r31;
        goto L80
    L90:
        r115 = null;
        goto L91
    L95:
        if (r114.isEmpty() == false) goto L97;
        return null;
    L97:
        Map r1 = r26.getExt();
        if (r1 != null) goto L100;
        r1 = MapsKt.emptyMap();
    L100:
        Object r33 = r122;
        Map r62 = MapsKt.plus(r1, TuplesKt.to(r33, CollectionsKt.joinToString$default(r27, ",", null, null, 0, null, null, 62, null)));
        return Message.copy$default(r26, null, null, null, 0, 0, null, 0, false, null, null, CollectionsKt.listOf(new Block(BlockType.BLOCK_TYPE_RICH_MEDIA_LAYOUT.getValue(), this.b, null, new BlockContent(null, null, new RichMediaLayoutBlock(r114, null, 2, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -5, -1, 31, null), false, null, null, null, 244, null)), null, null, r62, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -9217, 31, null);
    L113:
        return r113;
    L73:
        Map r34 = r2.getExt();
        if (r34 != null) goto L76;
        r34 = MapsKt.emptyMap();
    L76:
        r122 = "_mixed_richmedia_position_trace";
        r113 = Message.copy$default(r2, null, null, null, 0, 0, null, 0, false, null, null, r6, null, null, MapsKt.plus(r34, TuplesKt.to("_mixed_richmedia_position_trace", CollectionsKt.joinToString$default(r8, ",", null, null, 0, null, null, 62, null))), null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -9217, 31, null);
        goto L77
    }

    public final PrefetchRecommendVideoParam g(List<MediaEntity> r24, OuterFallbackInfo r25) {
        String r2 = null;
        if (e() == true) goto L6;
        return null;
    L6:
        if (r24.isEmpty() == false) goto L8;
        return null;
    L8:
        String r1 = this.a.getMessageId();
        boolean r3 = true;
        if (r1 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        return null;
    L17:
        CachedVideosPreloadFrom r11 = CachedVideosPreloadFrom.BIND_PULL_API;
        String r7 = this.a.getReplyId();
        String r6 = this.a.getMessageId();
        ArrayList r9 = new ArrayList();
        Iterator<T> r5 = r24.iterator();
    L19:
        if (r5.hasNext() == false) goto L26;
        MediaEntity r8 = (MediaEntity) r5.next();
        if (r8 == null) goto L23;
        String r10 = r8.getItem_id();
    L24:
        if (r10 == null) goto L19;
        r9.add(r10);
        goto L19
    L23:
        r10 = null;
        goto L24
    L26:
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r24.iterator();
    L28:
        if (r13.hasNext() == false) goto L35;
        MediaEntity r14 = (MediaEntity) r13.next();
        if (r14 == null) goto L32;
        String r15 = r14.getItem_id();
    L33:
        if (r15 == null) goto L28;
        r12.add(r15);
        goto L28
    L32:
        r15 = null;
        goto L33
    L35:
        f0 r16 = this.e;
        if (r16 != null) goto L38;
    L40:
        r3 = false;
    L41:
        f0 r17 = this.e;
        if (r17 == null) goto L45;
        r2 = r17.j();
    L45:
        return new PrefetchRecommendVideoParam(r6, r7, Boolean.TRUE, r9, 0, r11, r12, new t(this), Boolean.valueOf(r3), r2, false, null, r25, true, null, 19456, null);
    L38:
        if (r16.h(this.a) != true) goto L40;
    L11:
        if (r1.length() == 0) goto L14;
        r4 = false;
        goto L15
    }

    public final void l(fn8.c r66, fn8.w r67) {
        fn8.b r1 = r66.h;
        boolean r2 = r1 instanceof fn8.b.d;
        Object r6 = null;
        if (r2 == false) goto L5;
    L195:
        if (r2 == false) goto L197;
    L199:
        List<RichMediaItem> r3 = d(new k(this));
        Iterator<RichMediaItem> r4 = r3.iterator();
        int r8 = 0;
    L201:
        if (r4.hasNext() == false) goto L206;
        if (j(r4.next(), r66) == true) goto L204;
        r8 = r8 + 1;
        goto L201
    L204:
        int r19 = r8;
    L207:
        if (r19 < 0) goto L464;
        String r11 = this.a.getConversationId();
        if (r11 == null) goto L274;
        String r12 = this.a.getMessageId();
        if (r12 == null) goto L274;
        f0 r0 = this.e;
        if (r0 == null) goto L218;
        Fragment r5 = r0.getHostFragment();
    L412:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L225
        if (r5 == null) goto L222;
        FragmentManager r9 = r5.getParentFragmentManager();     // Catch: Throwable -> L225
    L223:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L225
    L228:
        if (Result.isFailure-impl(r10) == false) goto L230;
        r10 = null;
    L230:
        FragmentManager r13 = (FragmentManager) r10;
        if (r13 != null) goto L245;
        if (r5 == null) goto L236;
        FragmentActivity r14 = r5.getActivity();
        if (r14 == null) goto L236;
        r13 = r14.getSupportFragmentManager();
    L237:
        if (r13 != null) goto L245;
        FragmentActivity r15 = r67.getContext();
        if ((r15 instanceof FragmentActivity) == false) goto L241;
        FragmentActivity r16 = r15;
    L242:
        if (r16 == null) goto L244;
        r13 = r16.getSupportFragmentManager();
        goto L245
    L244:
        FragmentManager r17 = null;
    L246:
        if (r17 == null) goto L274;
        int r18 = z2.a.getCreationDetailLayoutConfig().c();
        IChatGalleryService.Companion r20 = IChatGalleryService.a;
        if (r20.h(h()) == false) goto L263;
        if (1 <= r18) goto L252;
    L254:
        boolean r21 = false;
    L255:
        if (r21 == false) goto L263;
        String r22 = this.a.getConversationId();
        f0 r23 = this.e;
        if (r23 == null) goto L259;
        Integer r24 = r23.getBotConversationType();
    L261:
        if (com.larus.bmhome.utils.i.e(r22, r24) == false) goto L263;
        boolean r25 = true;
    L264:
        if (r25 == false) goto L274;
        Message r26 = c(true, new g(this));
        if (r26 == null) goto L272;
        Map r27 = r26.getExt();
        if (r27 != null) goto L271;
        r27 = MapsKt.emptyMap();
    L271:
        Message r110 = Message.copy$default(r26, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, MapsKt.plus(r27, TuplesKt.to("rich_media_type", n())), null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8193, 31, null);
    L273:
        if (r110 == null) goto L274;
        Context r28 = r67.getContext();
        f0 r29 = this.e;
        if (r29 == null) goto L278;
        q0 r30 = r29.e();
    L279:
        int r31 = 1;
        IChatGalleryService.a.a(r20, r28, r17, r11, r12, r110, r30, r19, r67, null, 1792);
        boolean r111 = true;
    L280:
        if (r111 == true) goto L465;
        Context r112 = r67.getContext();
        List r113 = CollectionsKt.listOf(TuplesKt.to(Integer.valueOf(r19), r67));
        ArrayList r32 = new ArrayList();
        Iterator<T> r33 = r3.iterator();
    L284:
        if (r33.hasNext() == false) goto L400;
        RichMediaItem r34 = (RichMediaItem) r33.next();
        Integer r35 = r34.type;
        int r114 = RichMediaType.SEARCH_IMAGE.getValue();
        if (r35 != null) goto L289;
    L374:
        int r115 = RichMediaType.GENERIC_IMAGE.getValue();
        if (r35 != null) goto L378;
    L397:
        com.larus.bmhome.bigimg.l r116 = null;
    L398:
        if (r116 == null) goto L284;
        r32.add(r116);
        goto L284
    L378:
        if (r35.intValue() != r115) goto L397;
        GenericImageItem r36 = r34.imageItem;
        if (r36 == null) goto L397;
        String r37 = r36.id;
        if (r37 != null) goto L384;
        r37 = r36.uri;
    L384:
        String r210 = r37;
        String r38 = r36.resource;
        if (r38 != null) goto L387;
        String r211 = "";
    L388:
        String r39 = r36.uri;
        if (r39 != null) goto L391;
        String r212 = "";
    L392:
        String r40 = r36.coverUrl;
        if (r40 != null) goto L395;
        String r213 = "";
    L396:
        r116 = new com.larus.bmhome.bigimg.l(r210, r211, r212, r213, null, null, null, null, null, null, 2032);
        goto L398
    L395:
        r213 = r40;
        goto L396
    L391:
        r212 = r39;
        goto L392
    L387:
        r211 = r38;
        goto L388
    L289:
        if (r35.intValue() != r114) goto L374;
        SearchImageItem r41 = r34.image;
        if (r41 == null) goto L397;
        String r42 = r41.originThumbUrl;
        if (r42 != null) goto L295;
    L302:
        r42 = r41.thumbUrl;
        if (r42 != null) goto L305;
    L310:
        r42 = null;
    L311:
        if (r42 != null) goto L328;
        List r43 = r41.fullSizeUrl;
        if (r43 == null) goto L325;
        Iterator r44 = r43.iterator();
    L316:
        if (r44.hasNext() == false) goto L323;
        Object r117 = r44.next();
        if (((String) r117).length() <= 0) goto L320;
        boolean r118 = true;
    L321:
        if (r118 == false) goto L316;
    L324:
        r42 = (String) r117;
    L326:
        if (r42 != null) goto L328;
        r42 = "";
        goto L328
    L320:
        r118 = false;
        goto L321
    L323:
        r117 = null;
        goto L324
    L325:
        r42 = null;
    L328:
        String r119 = r41.itemId;
        if (r119 != null) goto L334;
        Long r120 = r41.id;
        if (r120 == null) goto L333;
        r119 = r120.toString();
        goto L334
    L333:
        String r214 = null;
    L335:
        List r121 = r41.fullSizeUrl;
        if (r121 == null) goto L351;
        Iterator r122 = r121.iterator();
    L339:
        if (r122.hasNext() == false) goto L346;
        Object r123 = r122.next();
        if (((String) r123).length() <= 0) goto L343;
        boolean r124 = true;
    L344:
        if (r124 == false) goto L339;
    L347:
        String r125 = (String) r123;
        if (r125 == null) goto L351;
        String r215 = r125;
    L352:
        String r126 = r41.uri;
        if (r126 != null) goto L355;
        String r216 = "";
    L356:
        String r127 = r41.originThumbUrl;
        if (r127 != null) goto L359;
    L368:
        String r217 = r42;
    L369:
        String r45 = r41.authorShortId;
        String r128 = r41.sourceAppName;
        String r129 = r41.sourceAppIcon;
        Long r130 = r41.sourceFrom;
        if (r130 == null) goto L372;
        Integer r218 = Integer.valueOf((int) r130.longValue());
    L373:
        r116 = new com.larus.bmhome.bigimg.l(r214, r215, r216, r217, r45, r128, r129, r218, r41.mainSiteUrl, r41.imgCaption, r41.docId);
        goto L398
    L372:
        r218 = null;
        goto L373
    L359:
        if (r127.length() <= 0) goto L361;
        boolean r131 = true;
    L362:
        if (r131 == true) goto L365;
        r127 = null;
    L365:
        if (r127 == null) goto L368;
        r217 = r127;
        goto L369
    L361:
        r131 = false;
        goto L362
    L355:
        r216 = r126;
        goto L356
    L343:
        r124 = false;
        goto L344
    L346:
        r123 = null;
    L351:
        r215 = r42;
    L334:
        r214 = r119;
        goto L335
    L305:
        if (r42.length() <= 0) goto L307;
        boolean r132 = true;
    L308:
        if (r132 == false) goto L310;
    L307:
        r132 = false;
        goto L308
    L295:
        if (r42.length() <= 0) goto L297;
        boolean r133 = true;
    L298:
        if (r133 == true) goto L301;
        r42 = null;
    L301:
        if (r42 != null) goto L328;
    L297:
        r133 = false;
        goto L298
    L400:
        uo8.k r46 = new uo8.k(MapsKt.mapOf(TuplesKt.to("rich_media_type", n())), null);
        if (r3.size() <= r31) goto L403;
        boolean r219 = true;
    L404:
        String r220 = this.a.getMessageId();
        f0 r47 = this.e;
        if (r47 != null) goto L407;
    L409:
        boolean r48 = false;
    L410:
        com.larus.bmhome.bigimg.k.c(r112, r113, r32, r19, r46, r219, null, r220, !r48, null, null, null, null, 15680);
        return;
    L407:
        if (r47.p() == true) goto L409;
        r48 = true;
        goto L410
    L403:
        r219 = false;
        goto L404
    L465:
        return;
    L278:
        r30 = null;
        goto L279
    L272:
        r110 = null;
        goto L273
    L259:
        r24 = null;
        goto L261
    L252:
        if (r18 >= 7) goto L254;
        r21 = true;
    L263:
        r25 = false;
        goto L264
    L241:
        r16 = null;
    L236:
        r13 = null;
    L245:
        r17 = r13;
        goto L246
    L222:
        r9 = null;
    L225:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L228
    L218:
        r5 = null;
    L274:
        r31 = 1;
        r111 = false;
        goto L280
    L464:
        return;
    L206:
        r19 = -1;
        goto L207
    L197:
        if ((r1 instanceof fn8.b.C0108b) == true) goto L199;
        return;
    L5:
        if ((r1 instanceof fn8.b.C0108b) == true) goto L195;
        boolean r50 = r1 instanceof fn8.b.a;
        if (r50 == false) goto L189;
        if (r50 == false) goto L11;
        fn8.b.a r51 = (fn8.b.a) r1;
    L12:
        if (r51 == null) goto L457;
        f0 r52 = this.e;
        if (r52 != null) goto L17;
    L19:
        boolean r53 = false;
    L20:
        if (r53 == true) goto L458;
        f0 r54 = this.e;
        if (r54 != null) goto L25;
    L27:
        boolean r55 = false;
    L28:
        if (r55 == false) goto L175;
        List<fn8.c> r56 = this.f;
        ArrayList r57 = new ArrayList();
        Iterator<T> r58 = r56.iterator();
    L31:
        if (r58.hasNext() == false) goto L38;
        Object r59 = r58.next();
        if (((fn8.c) r59).c != RichMediaKind.IMAGE) goto L35;
        boolean r60 = true;
    L36:
        if (r60 == false) goto L31;
        r57.add(r59);
        goto L31
    L35:
        r60 = false;
        goto L36
    L38:
        ArrayList r61 = new ArrayList();
        Iterator r62 = r57.iterator();
    L40:
        if (r62.hasNext() == false) goto L44;
        Object r63 = r62.next();
        if ((((fn8.c) r63).h instanceof fn8.b.a) == false) goto L40;
        r61.add(r63);
        goto L40
    L44:
        int r134 = r61.indexOf(r66);
        if (r134 < 0) goto L459;
        Context r135 = r67.getContext();
        List r136 = CollectionsKt.listOf(TuplesKt.to(Integer.valueOf(r134), r67));
        ArrayList r64 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r61, 10));
        Iterator r65 = r61.iterator();
    L49:
        if (r65.hasNext() == false) goto L161;
        fn8.c r68 = (fn8.c) r65.next();
        fn8.b r69 = r68.h;
        if ((r69 instanceof fn8.b.d) == false) goto L99;
        SearchImageItem r70 = ((fn8.b.d) r69).a;
        String r137 = r70.itemId;
        if (r137 != null) goto L58;
        Long r138 = r70.id;
        if (r138 == null) goto L57;
        r137 = r138.toString();
        goto L58
    L57:
        String r221 = null;
    L59:
        List r139 = r70.fullSizeUrl;
        if (r139 == null) goto L75;
        Iterator r140 = r139.iterator();
    L63:
        if (r140.hasNext() == false) goto L70;
        Object r141 = r140.next();
        if (((String) r141).length() <= 0) goto L67;
        boolean r142 = true;
    L68:
        if (r142 == false) goto L63;
    L71:
        String r143 = (String) r141;
        if (r143 == null) goto L75;
        String r222 = r143;
    L76:
        String r144 = r70.uri;
        if (r144 != null) goto L79;
        String r223 = "";
    L80:
        String r145 = r70.originThumbUrl;
        if (r145 != null) goto L83;
    L92:
        String r224 = r68.d;
    L93:
        String r71 = r70.authorShortId;
        String r146 = r70.sourceAppName;
        String r147 = r70.sourceAppIcon;
        Long r148 = r70.sourceFrom;
        if (r148 == null) goto L96;
        Integer r225 = Integer.valueOf((int) r148.longValue());
    L97:
        com.larus.bmhome.bigimg.l r149 = new com.larus.bmhome.bigimg.l(r221, r222, r223, r224, r71, r146, r147, r225, r70.mainSiteUrl, r70.imgCaption, r70.docId);
    L150:
        r64.add(r149);
        goto L49
    L96:
        r225 = null;
        goto L97
    L83:
        if (r145.length() <= 0) goto L85;
        boolean r150 = true;
    L86:
        if (r150 == true) goto L89;
        r145 = null;
    L89:
        if (r145 == null) goto L92;
        r224 = r145;
        goto L93
    L85:
        r150 = false;
        goto L86
    L79:
        r223 = r144;
        goto L80
    L67:
        r142 = false;
        goto L68
    L70:
        r141 = null;
    L75:
        r222 = r68.d;
    L58:
        r221 = r137;
        goto L59
    L99:
        if ((r69 instanceof fn8.b.a) == false) goto L137;
        CreationItem r72 = ((fn8.b.a) r69).a;
        String r151 = r72.id;
        ImageData r73 = r72.image;
        if (r73 == null) goto L108;
        ImageObj r152 = r73.imageOriRaw;
        if (r152 == null) goto L108;
        String r153 = r152.url;
        if (r153 == null) goto L108;
    L107:
        String r226 = r153;
        if (r73 == null) goto L123;
        String r154 = r73.key;
    L124:
        if (r154 != null) goto L126;
        String r227 = "";
    L127:
        if (r73 == null) goto L134;
        ImageObj r74 = r73.imageThumb;
        if (r74 == null) goto L134;
        String r75 = r74.url;
        if (r75 == null) goto L134;
        String r228 = r75;
    L135:
        r149 = new com.larus.bmhome.bigimg.l(r151, r226, r227, r228, null, null, null, null, null, null, 2032);
    L134:
        r228 = r68.d;
        goto L135
    L126:
        r227 = r154;
        goto L127
    L123:
        r154 = null;
    L108:
        if (r73 == null) goto L112;
        ImageObj r155 = r73.imageOrigin;
        if (r155 == null) goto L112;
        r153 = r155.url;
    L113:
        if (r153 != null) goto L107;
        if (r73 == null) goto L118;
        ImageObj r156 = r73.imagePreview;
        if (r156 == null) goto L118;
        r153 = r156.url;
    L119:
        if (r153 != null) goto L107;
        r153 = r68.d;
    L118:
        r153 = null;
    L112:
        r153 = null;
        goto L113
    L137:
        if ((r69 instanceof fn8.b.C0108b) == false) goto L152;
        GenericImageItem r76 = ((fn8.b.C0108b) r69).a;
        String r157 = r76.id;
        if (r157 != null) goto L141;
        r157 = r76.uri;
    L141:
        String r229 = r157;
        String r158 = r76.resource;
        if (r158 != null) goto L144;
        String r230 = "";
    L145:
        String r77 = r76.uri;
        if (r77 != null) goto L148;
        String r231 = "";
    L149:
        r149 = new com.larus.bmhome.bigimg.l(r229, r230, r231, r68.d, null, null, null, null, null, null, 2032);
        goto L150
    L148:
        r231 = r77;
        goto L149
    L144:
        r230 = r158;
        goto L145
    L152:
        if ((r69 instanceof fn8.b.e) == true) goto L159;
        if ((r69 instanceof fn8.b.c) == true) goto L159;
        throw new NoWhenBranchMatchedException();
    L159:
        throw new IllegalStateException("Image item cannot contain video source".toString());
    L161:
        if ((r66.h instanceof fn8.b.d) == false) goto L163;
        Map r78 = MapsKt.mapOf(TuplesKt.to("rich_media_type", n()));
    L164:
        uo8.k r79 = new uo8.k(r78, null);
        if (r61.size() <= 1) goto L167;
        boolean r232 = true;
    L168:
        String r233 = this.a.getMessageId();
        f0 r80 = this.e;
        if (r80 != null) goto L171;
    L173:
        boolean r81 = false;
    L174:
        com.larus.bmhome.bigimg.k.c(r135, r136, r64, r134, r79, r232, null, r233, !r81, null, null, null, null, 15680);
        return;
    L171:
        if (r80.p() == true) goto L173;
        r81 = true;
        goto L174
    L167:
        r232 = false;
        goto L168
    L163:
        r78 = MapsKt.emptyMap();
        goto L164
    L459:
        return;
    L175:
        List<CreationItem> r82 = a();
        Iterator r83 = ((ArrayList) r82).iterator();
    L177:
        if (r83.hasNext() == false) goto L181;
        Object r84 = r83.next();
        if (Intrinsics.areEqual((CreationItem) r84, r51.a) == false) goto L177;
        r6 = r84;
    L181:
        CreationItem r85 = (CreationItem) r6;
        if (r85 == null) goto L460;
        Message r86 = c(true, new j());
        if (r86 == null) goto L461;
        k(r82, r85, r67, null, r86);
        return;
    L461:
        return;
    L460:
        return;
    L25:
        if (r54.n() != true) goto L27;
        r55 = true;
        goto L28
    L458:
        return;
    L17:
        if (r52.m(f(r51.a)) != true) goto L19;
        r53 = true;
        goto L20
    L457:
        return;
    L11:
        r51 = null;
        goto L12
    L189:
        if ((r1 instanceof fn8.b.e) == false) goto L191;
        return;
    L191:
        if ((r1 instanceof fn8.b.c) == false) goto L194;
        return;
    L194:
        throw new NoWhenBranchMatchedException();
    }

    public final void k(List r18, CreationItem r19, fn8.w r20, s0 r21, Message r22) {
        f0 r5 = this.e;
        if (r5 != null) goto L5;
        return;
    L5:
        CoroutineScope r11 = r5.c();
        if (r11 != null) goto L8;
        return;
    L8:
        BuildersKt.launch$default(r11, null, null, new RichMediaItemActionDispatcher$openCreationPreview$1(r20, r22, r18, r19, r5, this, r11, r21, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.e] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.l] */
    public u(Message r8, String r9, int r10, List<RichMediaItem> r11, f0 r12, List<fn8.c> r13) {
        Intrinsics.checkNotNullParameter(r8, "message");
        Intrinsics.checkNotNullParameter(r11, "richMediaSourceItems");
        Intrinsics.checkNotNullParameter(r13, "orderedItems");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = new y(r8, r9, r12, new e(this), new l(this));
        this.h = new w(MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(RichMediaType.SEARCH_IMAGE.getValue()), new m(this)), TuplesKt.to(Integer.valueOf(RichMediaType.SEARCH_VIDEO.getValue()), new n(this)), TuplesKt.to(Integer.valueOf(RichMediaType.CREATION.getValue()), new o(this)), TuplesKt.to(Integer.valueOf(RichMediaType.GENERIC_IMAGE.getValue()), new p(this)), TuplesKt.to(Integer.valueOf(RichMediaType.GENERIC_VIDEO.getValue()), new q(this))}));
    }
}
