package com.larus.chat.gallery.impl.preview;

import com.larus.chat.gallery.api.PreviewScene;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarLayoutMode;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarVisualStyle;
import com.larus.platform.service.z2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sq9.a0;
import sq9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[PreviewScene.values().length];
            r0[PreviewScene.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L67:
            r0[PreviewScene.ATTACHMENT_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L75:
            r0[PreviewScene.CAMERA_RESULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L49:
            r0[PreviewScene.SEARCH_IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L51:
            r0[PreviewScene.CREATION_RECORD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L61:
            r0[PreviewScene.PRIVATE_ALBUM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L69:
            r0[PreviewScene.CREATION_CARD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L53:
            r0[PreviewScene.CLOUD_DRIVE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L18:
            a = r0;
            int[] r1 = new int[SourceType.values().length];
            r1[SourceType.USER_SEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
        L47:
            r1[SourceType.BOT_RESP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
        L59:
            r1[SourceType.CREATION_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
        L65:
            r1[SourceType.CREATION_RECORD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L40
        L71:
            r1[SourceType.ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L41
        L45:
            r1[SourceType.ATTACHMENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L42
        L57:
            r1[SourceType.CAMERA_RESULT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L43
        L63:
            r1[SourceType.CLOUD_DRIVE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L44
        L27:
            b = r1;
        }
    }

    static {
    }

    public u() {
    }

    public static List b(ToolbarButtonType... r4) {
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(r4[r2].getKey());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static r c(final PreviewScene r14) {
        Intrinsics.checkNotNullParameter(r14, "scene");
        final sq9.e r0 = z2.a.getCreationDetailLayoutConfig();
        if (r14 == PreviewScene.CREATION_RECORD) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        ToolbarLayoutMode r2 = ToolbarLayoutMode.HORIZONTAL;
    L12:
        ToolbarLayoutMode r6 = r2;
        ToolbarVisualStyle r7 = ToolbarVisualStyle.MEDIA_SOURCE_V4;
        boolean r8 = r0.e();
        final a0 r4 = null;
        Function1 r9 = new s(r4, r14, r0);
        if (r14 != PreviewScene.SEARCH_IMAGE) goto L15;
        boolean r10 = true;
    L17:
        if (r14 != PreviewScene.CLOUD_DRIVE) goto L19;
    L21:
        boolean r11 = false;
    L23:
        if (r14 != PreviewScene.MESSAGE) goto L25;
    L28:
        boolean r12 = true;
    L29:
        int r3 = a.a[r14.ordinal()];
        if (r3 != 1) goto L32;
    L36:
        boolean r5 = uy8.b.c();
    L38:
        return new r(r14, r6, r7, r8, r9, r10, r11, r12, r5);
    L32:
        if (r3 == 2) goto L36;
        if (r3 == 3) goto L36;
        r5 = r0.b();
        goto L38
    L25:
        if (r14 == PreviewScene.CAMERA_RESULT) goto L28;
        r12 = false;
        goto L29
    L19:
        if (r6 != ToolbarLayoutMode.VERTICAL) goto L21;
        r11 = true;
        goto L23
    L15:
        r10 = false;
        goto L17
    L8:
        ToolbarLayoutMode.a r13 = ToolbarLayoutMode.Companion;
        int r15 = r0.d();
        r13.getClass();
        if (r15 != 1) goto L11;
        r2 = ToolbarLayoutMode.HORIZONTAL;
        goto L12
    L11:
        r2 = ToolbarLayoutMode.VERTICAL;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public static a0 a(z r1, SourceType r2) {
        switch(a.b[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            default: goto L5;
        };
    L6:
        if (r1 == null) goto L14;
        return r1.c();
    L8:
        if (r1 == null) goto L14;
        return r1.b();
    L10:
        if (r1 == null) goto L14;
        return r1.a();
    L12:
        if (r1 == null) goto L14;
        return r1.d();
    L14:
        return null;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static a0 d(PreviewScene r10, SourceType r11, a0 r12) {
        switch(a.a[r10.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L5;
        };
    L7:
        List r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MORE});
        List r8 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.SHARE, ToolbarButtonType.DOWNLOAD, ToolbarButtonType.RENAME, ToolbarButtonType.MOVE, ToolbarButtonType.DELETE});
    L17:
        if (r10 != PreviewScene.PRIVATE_ALBUM) goto L19;
    L22:
        boolean r9 = true;
    L23:
        if (r9 == true) goto L25;
        if (r12 == null) goto L28;
    L37:
        Set r13 = CollectionsKt.toSet(CollectionsKt.plus(r0, r8));
        List r1 = r12.c();
        if (r1 != null) goto L40;
        r1 = CollectionsKt.emptyList();
    L40:
        List r2 = CollectionsKt.filterNotNull(r1);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L42:
        if (r4.hasNext() == false) goto L46;
        Object r5 = r4.next();
        if (r13.contains((String) r5) == true) goto L42;
        r3.add(r5);
        goto L42
    L46:
        List r6 = CollectionsKt.plus(r0, r3);
        if (a.a[r10.ordinal()] != 1) goto L49;
        List r14 = b(new ToolbarButtonType[]{ToolbarButtonType.SELECT});
    L53:
        List r15 = r8;
        List r16 = r12.b();
        if (r16 != null) goto L56;
        r16 = CollectionsKt.emptyList();
    L56:
        List r17 = CollectionsKt.filterNotNull(r16);
        ArrayList r7 = new ArrayList();
        Iterator r18 = r17.iterator();
    L58:
        if (r18.hasNext() == false) goto L63;
        Object r19 = r18.next();
        if (r13.contains((String) r19) == true) goto L58;
        r7.add(r19);
        goto L58
    L63:
        return new a0(r6, r14, CollectionsKt.plus(r15, r7));
    L49:
        List r110 = r12.a();
        if (r110 != null) goto L52;
        r110 = CollectionsKt.emptyList();
    L52:
        r14 = CollectionsKt.filterNotNull(r110);
        goto L53
    L28:
        switch(a.b[r11.ordinal()]) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L31;
            case 8: goto L31;
            default: goto L30;
        };
    L31:
        List r111 = CollectionsKt.emptyList();
    L36:
        r12 = new a0(r111, 6);
        goto L37
    L32:
        r111 = b(new ToolbarButtonType[]{ToolbarButtonType.SHARE, ToolbarButtonType.DOWNLOAD, ToolbarButtonType.MARK, ToolbarButtonType.PUBLISH, ToolbarButtonType.SET_PRIVATE});
        goto L36
    L33:
        r111 = b(new ToolbarButtonType[]{ToolbarButtonType.SHARE, ToolbarButtonType.DOWNLOAD, ToolbarButtonType.MARK, ToolbarButtonType.PUBLISH, ToolbarButtonType.SET_PRIVATE});
        goto L36
    L34:
        r111 = b(new ToolbarButtonType[]{ToolbarButtonType.SHARE, ToolbarButtonType.DOWNLOAD, ToolbarButtonType.MARK, ToolbarButtonType.VIEW_SOURCE});
        goto L36
    L35:
        r111 = b(new ToolbarButtonType[]{ToolbarButtonType.SHARE, ToolbarButtonType.DOWNLOAD, ToolbarButtonType.MARK});
        goto L36
    L30:
        throw new NoWhenBranchMatchedException();
    L25:
        return new a0(r0, CollectionsKt.emptyList(), r8);
    L19:
        if (r10 == PreviewScene.CLOUD_DRIVE) goto L22;
        r9 = false;
        goto L23
    L8:
        r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.SHARE, ToolbarButtonType.DOWNLOAD});
        r8 = CollectionsKt.emptyList();
        goto L17
    L9:
        r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MORE, ToolbarButtonType.SHARE, ToolbarButtonType.DOWNLOAD});
        r8 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.DELETE});
        goto L17
    L10:
        r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MORE, ToolbarButtonType.VIEW_SOURCE, ToolbarButtonType.SHARE});
        r8 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.DOWNLOAD});
        goto L17
    L11:
        r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.CROP, ToolbarButtonType.DOWNLOAD});
        r8 = CollectionsKt.emptyList();
        goto L17
    L12:
        r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.CROP});
        r8 = CollectionsKt.emptyList();
        goto L17
    L13:
        r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.CROP, ToolbarButtonType.SELECT});
        r8 = CollectionsKt.emptyList();
        goto L17
    L5:
        if (a.b[r11.ordinal()] != 1) goto L14;
        r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.DOWNLOAD, ToolbarButtonType.SHARE});
    L15:
        r8 = CollectionsKt.emptyList();
        goto L17
    L14:
        r0 = b(new ToolbarButtonType[]{ToolbarButtonType.MARK, ToolbarButtonType.DOWNLOAD, ToolbarButtonType.SHARE});
        goto L15
    }
}
