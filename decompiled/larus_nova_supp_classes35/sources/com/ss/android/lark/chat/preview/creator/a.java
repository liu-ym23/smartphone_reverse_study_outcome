package com.ss.android.lark.chat.preview.creator;

import android.content.Context;
import android.view.View;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.chat.preview.components.ChattersPreviewComponent;
import com.ss.android.lark.chat.preview.components.TimingComponent;
import com.ss.android.lark.chat.preview.components.a0;
import com.ss.android.lark.chat.preview.components.c;
import com.ss.android.lark.chat.preview.components.c0;
import com.ss.android.lark.chat.preview.components.h;
import com.ss.android.lark.chat.preview.components.j;
import com.ss.android.lark.chat.preview.components.k;
import com.ss.android.lark.chat.preview.components.n;
import com.ss.android.lark.chat.preview.components.q;
import com.ss.android.lark.chat.preview.components.t;
import com.ss.android.lark.chat.preview.components.u;
import com.ss.android.lark.chat.preview.components.v;
import com.ss.android.lark.chat.preview.components.w;
import com.ss.android.lark.chat.preview.components.z;
import com.ss.android.lark.chat.preview.entity.component.property.AvatarProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ButtonProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ChattersPreviewProperty;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.chat.preview.entity.component.property.EmptyProperty;
import com.ss.android.lark.chat.preview.entity.component.property.IGProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ImageContainerProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ImageProperty;
import com.ss.android.lark.chat.preview.entity.component.property.LinearLayoutProperty;
import com.ss.android.lark.chat.preview.entity.component.property.OverSizeTextProperty;
import com.ss.android.lark.chat.preview.entity.component.property.PreviewHeaderProperty;
import com.ss.android.lark.chat.preview.entity.component.property.RichTextProperty;
import com.ss.android.lark.chat.preview.entity.component.property.SpinButtonProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TagListProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TextViewProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TimeProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TimeZoneProperty;
import com.ss.android.lark.chat.preview.entity.component.property.UDLoadingProperty;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.RenderRouterEntity;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.KeyTag;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.export.flexlayout.FlexLayoutProperty;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.integrator.im.f;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import q6c.e;
import vcb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final d a;
    public final WeakReference<Context> b;
    public final ddb.a c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.creator.a$a, reason: collision with other inner class name */
    public static final class C0109a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L85:
            r0[Type.EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L99:
            r0[Type.CARD_CONTAINER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[Type.LINEAR_LAYOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L65:
            r0[Type.FLEX_LAYOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L79:
            r0[Type.HEADER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L93:
            r0[Type.RICHTEXT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L71:
            r0[Type.IMAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L87:
            r0[Type.CHATTERS_PREVIEW.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L89:
            r0[Type.BUTTON.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
        L55:
            r0[Type.ICON_BUTTON.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
        L83:
            r0[Type.TEXT_BUTTON.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
        L97:
            r0[Type.TIME.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L53:
            r0[Type.TEXT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
        L67:
            r0[Type.TAG_LIST.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
        L95:
            r0[Type.SPIN_BUTTON.ordinal()] = 16;     // Catch: NoSuchFieldError -> L44
        L59:
            r0[Type.AVATAR.ordinal()] = 17;     // Catch: NoSuchFieldError -> L45
        L63:
            r0[Type.VIDEO.ordinal()] = 18;     // Catch: NoSuchFieldError -> L46
        L81:
            r0[Type.DOC_IMAGE.ordinal()] = 19;     // Catch: NoSuchFieldError -> L47
        L57:
            r0[Type.LOADING.ordinal()] = 20;     // Catch: NoSuchFieldError -> L48
        L75:
            r0[Type.TIME_ZONE.ordinal()] = 21;     // Catch: NoSuchFieldError -> L49
        L77:
            r0[Type.OVERSIZED_TEXT.ordinal()] = 22;     // Catch: NoSuchFieldError -> L50
        L91:
            r0[Type.ENGINE.ordinal()] = 23;     // Catch: NoSuchFieldError -> L51
        L69:
            r0[Type.IMAGE_CONTAINER.ordinal()] = 24;     // Catch: NoSuchFieldError -> L52
        L27:
            a = r0;
        }
    }

    static {
    }

    public static void f(Style r6) {
        float r0 = 0.0f;
        ValueType r1 = null;
        if (r6 == null) goto L19;
        Value r2 = r6.getWidth();
        if (r2 == null) goto L7;
        ValueType r3 = r2.getValueType();
    L8:
        ValueType r4 = ValueType.POINT;
        if (r3 != r4) goto L17;
        float r5 = zz7.b.d().getMultiplier();
        Value r7 = r6.getWidth();
        if (r7 == null) goto L15;
        Float r8 = r7.getValue();
        if (r8 == null) goto L15;
        float r9 = r8.floatValue();
    L16:
        Value r10 = new Value(r4, Float.valueOf(r5 * r9));
    L18:
        r6.setScaleWidth(r10);
    L15:
        r9 = 0.0f;
        goto L16
    L17:
        Value.Companion.getClass();
        r10 = Value.a.a();
        goto L18
    L7:
        r3 = null;
    L19:
        if (r6 == null) goto L34;
        Value r11 = r6.getHeight();
        if (r11 == null) goto L23;
        r1 = r11.getValueType();
    L23:
        ValueType r12 = ValueType.POINT;
        if (r1 != r12) goto L31;
        float r13 = zz7.b.d().getMultiplier();
        Value r14 = r6.getHeight();
        if (r14 == null) goto L30;
        Float r15 = r14.getValue();
        if (r15 == null) goto L30;
        r0 = r15.floatValue();
    L30:
        Value r16 = new Value(r12, Float.valueOf(r13 * r0));
    L32:
        r6.setScaleHeight(r16);
        return;
    L31:
        Value.Companion.getClass();
        r16 = Value.a.a();
        goto L32
    }

    public a(d r2, View.OnLongClickListener r3) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
        this.b = new WeakReference(r2.getContext());
        this.c = new ddb.a(r2);
    }

    public final q6c.b c(UrlCardPreviewEntity r11, String r12) {
        if (r11 != null) goto L5;
        return null;
    L5:
        boolean r2 = false;
        if (r11.getPreviewBody() == null) goto L45;
        UrlPreviewBody r9 = r11.getPreviewBody();
        if (r9 == null) goto L57;
        if (r12 != null) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L61;
        Map<String, UrlPreviewState> r14 = r9.getStates();
        if (r14 == null) goto L20;
        UrlPreviewState r15 = r14.get(r12);
    L21:
        if (r15 == null) goto L23;
        LinkedHashMap<String, UrlPreviewAction> r8 = r15.getActions();
    L24:
        if (r15 == null) goto L26;
        r15.getType();
    L26:
        HashMap<String, UrlPreviewTemplate> r16 = r9.getTemplates();
        if (r16 == null) goto L32;
        if (r15 == null) goto L30;
        String r17 = r15.getTemplateId();
    L31:
        UrlPreviewTemplate r18 = r16.get(r17);
    L33:
        if (r18 == null) goto L42;
        String r19 = r18.getRootComponentId();
        if (r19 == null) goto L42;
        if (r19.length() != 0) goto L39;
        boolean r110 = true;
    L40:
        if (r110 == true) goto L42;
        r2 = true;
        goto L42
    L39:
        r110 = false;
    L42:
        if (r2 == true) goto L44;
        Log.e("[URLPreview] TangramCreator", "urlPreviewTemplate is null");
        return null;
    L44:
        q6c.b r111 = e(this, r18.getRootComponentId(), r18.getElements(), r8, r9);
        b(r111, r18.getRootComponentId(), r18.getElements(), r8, r9);
        return r111;
    L30:
        r17 = null;
        goto L31
    L32:
        r18 = null;
        goto L33
    L23:
        r8 = null;
        goto L24
    L20:
        r15 = null;
        goto L21
    L61:
        return null;
    L11:
        if (r12.length() == 0) goto L14;
        r13 = false;
        goto L15
    L57:
        return null;
    L45:
        RenderRouterEntity r112 = r11.getRenderRouterEntity();
        ddb.a r113 = this.c;
        r113.getClass();
        if (r112 == null) goto L62;
        String r1 = r112.getRootId();
        if (r1 != null) goto L51;
    L52:
        r2 = true;
    L53:
        if (r2 == false) goto L55;
        Log.e("[URLPreview] RenderRouterCreator", "renderRouterEntity rootId is null");
        return null;
    L55:
        q6c.b r0 = r113.b(r112.getRootId(), r112.getElements());
        r113.a(r0, r112.getRootId(), r112.getElements());
        return r0;
    L51:
        if (r1.length() != 0) goto L53;
    L62:
        return null;
    }

    public static t6c.d a(final LKUIRoundableLayout r1, final q6c.b r2, final int r3) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return (t6c.d) LazyKt.lazy(new ChatPreviewComponentCreator$bindTree$frameRenderer$2(r2, r1, r3)).getValue();
    }

    public static /* synthetic */ q6c.b e(a r6, String r7, Map r8, Map r9, UrlPreviewBody r10) {
        return r6.d(r7, r8, r9, r10, false);
    }

    public final void b(q6c.b r8, String r9, Map r10, Map r11, UrlPreviewBody r12) {
        if (r9 == null) goto L25;
        if (r10 == null) goto L32;
        UrlPreviewComponent r13 = (UrlPreviewComponent) r10.get(r9);
        if (r13 != null) goto L8;
        return;
    L8:
        List<String> r14 = r13.getChildIds();
        if (r14 == null) goto L31;
        Iterator<T> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L33;
        String r3 = (String) r15.next();
        q6c.b r2 = e(this, r3, r10, r11, r12);
        if (r2 == null) goto L12;
        if ((r8 instanceof e) == false) goto L19;
        ArrayList r0 = new ArrayList();
        r0.add(r2);
        e r1 = (e) r8;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "components");
        ((q6c.b) r1).d = r0;
    L24:
        b(r2, r3, r10, r11, r12);
        goto L12
    L19:
        if ((r8 instanceof q6c.d) == false) goto L24;
        q6c.d r4 = (q6c.d) r8;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "component");
        if (((q6c.b) r4).d != null) goto L23;
        ((q6c.b) r4).d = new ArrayList();
    L23:
        ArrayList r5 = ((q6c.b) r4).d;
        Intrinsics.checkNotNull(r5);
        r5.add(r2);
        goto L24
    L33:
        return;
    L31:
        return;
    L32:
        return;
    }

    public final q6c.b d(String r34, Map r35, Map r36, UrlPreviewBody r37, boolean r38) {
        com.ss.android.lark.chat.preview.actions.b r7 = null;
        Float r8 = null;
        r7 = null;
        r7 = null;
        if (r34 == null) goto L297;
        if (r35 == null) goto L316;
        UrlPreviewComponent r0 = (UrlPreviewComponent) r35.get(r34);
        if (r0 != null) goto L9;
        return null;
    L9:
        BaseProperty r1 = r0.getProperty();
        Style r11 = r0.getStyle();
        float r9 = 16.0f;
        boolean r10 = true;
        switch(b.a[r0.getType().ordinal()]) {
            case 1: goto L277;
            case 2: goto L255;
            case 3: goto L250;
            case 4: goto L245;
            case 5: goto L240;
            case 6: goto L231;
            case 7: goto L226;
            case 8: goto L221;
            case 9: goto L216;
            case 10: goto L193;
            case 11: goto L155;
            case 12: goto L155;
            case 13: goto L132;
            case 14: goto L110;
            case 15: goto L97;
            case 16: goto L92;
            case 17: goto L87;
            case 18: goto L82;
            case 19: goto L77;
            case 20: goto L50;
            case 21: goto L45;
            case 22: goto L40;
            case 23: goto L18;
            case 24: goto L13;
            default: goto L279;
        };
    L277:
        EmptyProperty r15 = new EmptyProperty(Type.UNKNOWN, null, 2, null);
        Style.Companion.getClass();
        q6c.b r2 = new c(r15, new Style.a().a(), this.a, null, null);
    L314:
        return r2;
    L279:
        g6b.a.InterfaceC0223a r3 = g6b.a.a;
        if (r3 == null) goto L284;
        f r4 = r3.d();
        if (r4 == null) goto L284;
        com.ss.android.lark.export.c r5 = r4.b(r0.getType());
    L285:
        if (r5 != null) goto L287;
    L289:
        r10 = false;
    L290:
        if (r10 == true) goto L293;
        if (r5 == null) goto L293;
        e r6 = r5.c();
    L295:
        if ((r6 instanceof q6c.b) == true) goto L310;
        return null;
    L310:
        return r6;
    L293:
        r6 = null;
        goto L295
    L287:
        if (r5.a() == true) goto L289;
    L284:
        r5 = null;
        goto L285
    L13:
        if ((r1 instanceof ImageContainerProperty) == false) goto L15;
        ImageContainerProperty r12 = (ImageContainerProperty) r1;
    L298:
        return new com.ss.android.lark.chat.preview.components.e(r12, r11, this.a);
    L15:
        r12 = new ImageContainerProperty(null, null, null);
        goto L298
    L18:
        if ((r1 instanceof EngineProperty) == false) goto L20;
        EngineProperty r13 = (EngineProperty) r1;
    L21:
        g6b.a.InterfaceC0223a r14 = g6b.a.a;
        if (r14 == null) goto L26;
        f r16 = r14.d();
        if (r16 == null) goto L26;
        com.ss.android.lark.export.d r17 = r16.a(r13.getEngineType());
    L27:
        if (r17 != null) goto L29;
    L31:
        r10 = false;
    L32:
        if (r10 == true) goto L35;
        if (r17 == null) goto L35;
        r6 = r17.c();
    L37:
        if ((r6 instanceof q6c.b) == true) goto L310;
        return null;
    L35:
        r6 = null;
        goto L37
    L29:
        if (r17.a() == true) goto L31;
    L26:
        r17 = null;
        goto L27
    L20:
        r13 = new EngineProperty(null, null, 3, null);
        goto L21
    L40:
        if ((r1 instanceof OverSizeTextProperty) == false) goto L42;
        OverSizeTextProperty r18 = (OverSizeTextProperty) r1;
    L43:
        r6 = new j(r18, r11, this.a);
        goto L310
    L42:
        r18 = new OverSizeTextProperty(null, 0, 0, null, 15, null);
        goto L43
    L45:
        if ((r1 instanceof TimeZoneProperty) == false) goto L47;
        TimeZoneProperty r19 = (TimeZoneProperty) r1;
    L300:
        return new v(r19, r11, this.a);
    L47:
        r19 = new TimeZoneProperty(null, null, null, null, null, null, 0, 0, false, 511, null);
        goto L300
    L50:
        if ((r1 instanceof UDLoadingProperty) == false) goto L52;
        UDLoadingProperty r20 = (UDLoadingProperty) r1;
    L53:
        if (r11 != null) goto L55;
        ValueType r21 = ValueType.POINT;
        r11 = new Style(null, null, null, null, null, new Value(r21, Float.valueOf(16.0f)), new Value(r21, Float.valueOf(16.0f)), null, null, null, null, 0, 0, 0.0f, null, 32671, null);
    L55:
        Value r22 = r11.getWidth();
        if (r22 == null) goto L69;
        Value r23 = r11.getWidth();
        if (r23 == null) goto L62;
        Float r24 = r23.getValue();
        if (r24 == null) goto L62;
        float r25 = r24.floatValue();
    L63:
        Value r26 = r11.getHeight();
        if (r26 == null) goto L68;
        Float r27 = r26.getValue();
        if (r27 == null) goto L68;
        r9 = r27.floatValue();
    L68:
        r22.setValue(Float.valueOf(Math.max(r25, r9)));
        Unit r28 = Unit.INSTANCE;
    L62:
        r25 = 16.0f;
    L69:
        Value r29 = r11.getHeight();
        if (r29 == null) goto L75;
        Value r30 = r11.getWidth();
        if (r30 == null) goto L74;
        r8 = r30.getValue();
    L74:
        r29.setValue(r8);
        Unit r31 = Unit.INSTANCE;
    L75:
        f(r11);
        return new z(r20, r11, this.a);
    L52:
        r20 = new UDLoadingProperty();
        goto L53
    L77:
        if ((r1 instanceof DocImageProperty) == false) goto L79;
        DocImageProperty r32 = (DocImageProperty) r1;
    L302:
        return new com.ss.android.lark.chat.preview.components.b(r32, r11, this.a);
    L79:
        r32 = new DocImageProperty(null, null, null, null, null, null, null, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
        goto L302
    L82:
        if ((r1 instanceof VideoProperty) == false) goto L84;
        VideoProperty r33 = (VideoProperty) r1;
    L303:
        return new c0(r33, r11, this.a, r34);
    L84:
        r33 = new VideoProperty(null, null, null, 0, null, null, null, 127, null);
        goto L303
    L87:
        if ((r1 instanceof AvatarProperty) == false) goto L89;
        AvatarProperty r39 = (AvatarProperty) r1;
    L90:
        f(r11);
        r6 = new com.ss.android.lark.chat.preview.components.a(r39, r11, this.a);
        goto L310
    L89:
        r39 = new AvatarProperty(null, 1, null);
        goto L90
    L92:
        if ((r1 instanceof SpinButtonProperty) == false) goto L94;
        SpinButtonProperty r40 = (SpinButtonProperty) r1;
    L304:
        return new q(r40, r11, this.a, r36, r34);
    L94:
        r40 = new SpinButtonProperty(null, null, null, null, 15, null);
        goto L304
    L97:
        if ((r1 instanceof TagListProperty) == false) goto L99;
        TagListProperty r41 = (TagListProperty) r1;
    L100:
        List<KeyTag> r42 = r41.getMixedTags();
        if (r42 != null) goto L103;
    L105:
        r10 = false;
    L106:
        if (r10 == false) goto L108;
        r6 = new t(r41, r11, this.a);
        goto L310
    L108:
        r6 = new a0(r41, r11, this.a);
        goto L310
    L103:
        if (r42.isEmpty() != true) goto L105;
    L99:
        r41 = new TagListProperty(null, null, 0, 7, null);
        goto L100
    L110:
        if ((r1 instanceof TextViewProperty) == false) goto L112;
        TextViewProperty r43 = (TextViewProperty) r1;
    L113:
        String r44 = r43.getActionId();
        if (r44 != null) goto L116;
    L121:
        r10 = false;
    L122:
        if (r10 == false) goto L130;
        if (r36 == null) goto L125;
        UrlPreviewAction r45 = (UrlPreviewAction) r36.get(r43.getActionId());
    L126:
        if (r45 == null) goto L130;
        String r46 = r43.getActionId();
        if (r46 == null) goto L130;
        r7 = com.ss.android.lark.chat.preview.actions.a.a((UrlPreviewAction) r36.get(r46), r46, r37, this.a, r36);
        goto L130
    L125:
        r45 = null;
    L130:
        r6 = new u(r43, r11, this.a, r7);
        goto L310
    L116:
        if (r44.length() <= 0) goto L118;
        boolean r47 = true;
    L119:
        if (r47 != true) goto L121;
    L118:
        r47 = false;
        goto L119
    L112:
        r43 = new TextViewProperty(null, 0, null, 7, null);
        goto L113
    L132:
        if ((r1 instanceof TimeProperty) == false) goto L134;
        TimeProperty r48 = (TimeProperty) r1;
    L135:
        String r49 = r48.getNtpActionId();
        if (r49 != null) goto L138;
    L143:
        r10 = false;
    L144:
        if (r10 == false) goto L152;
        if (r36 == null) goto L147;
        UrlPreviewAction r50 = (UrlPreviewAction) r36.get(r48.getNtpActionId());
    L148:
        if (r50 == null) goto L152;
        String r51 = r48.getNtpActionId();
        if (r51 == null) goto L152;
        com.ss.android.lark.chat.preview.actions.b r52 = com.ss.android.lark.chat.preview.actions.a.a((UrlPreviewAction) r36.get(r51), r51, r37, this.a, r36);
    L305:
        return new TimingComponent(r48, r11, this.a, r52, r34, r38);
    L147:
        r50 = null;
    L152:
        r52 = null;
        goto L305
    L138:
        if (r49.length() <= 0) goto L140;
        boolean r53 = true;
    L141:
        if (r53 != true) goto L143;
    L140:
        r53 = false;
        goto L141
    L134:
        r48 = new TimeProperty(null, null, null, null, null, 31, null);
        goto L135
    L155:
        if ((r1 instanceof ButtonProperty) == false) goto L157;
        ButtonProperty r54 = (ButtonProperty) r1;
    L158:
        String r55 = r54.getActionId();
        if (r55 != null) goto L161;
    L166:
        r10 = false;
    L167:
        if (r10 == false) goto L175;
        if (r36 == null) goto L170;
        UrlPreviewAction r56 = (UrlPreviewAction) r36.get(r54.getActionId());
    L171:
        if (r56 == null) goto L175;
        String r57 = r54.getActionId();
        if (r57 == null) goto L175;
        com.ss.android.lark.chat.preview.actions.b r110 = com.ss.android.lark.chat.preview.actions.a.a((UrlPreviewAction) r36.get(r57), r57, r37, this.a, r36);
    L176:
        f(r11);
        float r58 = 0.0f;
        if (r11 == null) goto L183;
        Value r59 = r11.getScaleWidth();
        if (r59 == null) goto L183;
        Float r60 = r59.getValue();
        if (r60 == null) goto L183;
        float r61 = r60.floatValue();
    L184:
        Integer r62 = Integer.valueOf(UIHelper.dp2px(r61));
        if (r11 == null) goto L306;
        Value r63 = r11.getScaleHeight();
        if (r63 == null) goto L306;
        Float r64 = r63.getValue();
        if (r64 == null) goto L306;
        r58 = r64.floatValue();
    L306:
        return new w(r62, Integer.valueOf(UIHelper.dp2px(r58)), r54, r11, this.a, r110, r34);
    L183:
        r61 = 0.0f;
        goto L184
    L170:
        r56 = null;
    L175:
        r110 = null;
        goto L176
    L161:
        if (r55.length() <= 0) goto L163;
        boolean r65 = true;
    L164:
        if (r65 != true) goto L166;
    L163:
        r65 = false;
        goto L164
    L157:
        r54 = new ButtonProperty(null, null, null, null, null, null, 63, null);
        goto L158
    L193:
        if ((r1 instanceof ButtonProperty) == false) goto L195;
        ButtonProperty r66 = (ButtonProperty) r1;
    L196:
        String r67 = r66.getActionId();
        if (r67 != null) goto L199;
    L204:
        r10 = false;
    L205:
        if (r10 == false) goto L213;
        if (r36 == null) goto L208;
        UrlPreviewAction r68 = (UrlPreviewAction) r36.get(r66.getActionId());
    L209:
        if (r68 == null) goto L213;
        String r69 = r66.getActionId();
        if (r69 == null) goto L213;
        com.ss.android.lark.chat.preview.actions.b r111 = com.ss.android.lark.chat.preview.actions.a.a((UrlPreviewAction) r36.get(r69), r69, r37, this.a, r36);
    L307:
        return new w(Integer.valueOf(UIHelper.dp2px(16.0f)), Integer.valueOf(UIHelper.dp2px(11.0f)), r66, r11, this.a, r111, r34);
    L208:
        r68 = null;
    L213:
        r111 = null;
        goto L307
    L199:
        if (r67.length() <= 0) goto L201;
        boolean r70 = true;
    L202:
        if (r70 != true) goto L204;
    L201:
        r70 = false;
        goto L202
    L195:
        r66 = new ButtonProperty(null, null, null, null, null, null, 63, null);
        goto L196
    L216:
        if ((r1 instanceof ChattersPreviewProperty) == false) goto L218;
        ChattersPreviewProperty r71 = (ChattersPreviewProperty) r1;
    L219:
        d r72 = this.a;
        return new ChattersPreviewComponent(r71, r11, r72, new com.ss.android.lark.chat.preview.creator.b(this, r71, r34, r72));
    L218:
        r71 = new ChattersPreviewProperty(null, null, null, null, null, null, 63, null);
        goto L219
    L221:
        if ((r1 instanceof ImageProperty) == false) goto L223;
        ImageProperty r73 = (ImageProperty) r1;
    L224:
        r6 = new com.ss.android.lark.chat.preview.components.f(r73, r11, this.a);
        goto L310
    L223:
        r73 = new ImageProperty(null, null, null, null, null, null, 60, null);
        goto L224
    L226:
        if ((r1 instanceof RichTextProperty) == false) goto L228;
        RichTextProperty r74 = (RichTextProperty) r1;
    L309:
        return new n(r74, r11, this.a, r36, r37, r34);
    L228:
        r74 = new RichTextProperty(null, 0, null, 6, null);
        goto L309
    L231:
        if ((r1 instanceof PreviewHeaderProperty) == false) goto L233;
        PreviewHeaderProperty r75 = (PreviewHeaderProperty) r1;
    L234:
        PreviewHeaderProperty r76 = r75;
        s6c.b r77 = d(r76.getChildComponentId(), r35, r36, r37, true);
        if ((r77 instanceof s6c.b) == false) goto L237;
        r2 = new k(r77, r76, r11, this.a);
        goto L314
    L237:
        r6 = new k(null, r76, r11, this.a);
        goto L310
    L233:
        r75 = new PreviewHeaderProperty(null, BuildConfig.FLAVOR, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131069, null);
        goto L234
    L240:
        if ((r1 instanceof FlexLayoutProperty) == false) goto L242;
        FlexLayoutProperty r78 = (FlexLayoutProperty) r1;
    L311:
        return new adb.a(r78, r11, this.a);
    L242:
        r78 = new FlexLayoutProperty(null, null, 0.0f, 0.0f, null, null, null, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
        goto L311
    L245:
        if ((r1 instanceof LinearLayoutProperty) == false) goto L247;
        LinearLayoutProperty r79 = (LinearLayoutProperty) r1;
    L312:
        return new h(r79, r11, this.a);
    L247:
        r79 = new LinearLayoutProperty(null, 0.0f, 0.0f, 0.0f, null, null, null, 127, null);
        goto L312
    L250:
        if ((r1 instanceof IGProperty) == false) goto L252;
        IGProperty r80 = (IGProperty) r1;
    L253:
        r6 = new com.ss.android.lark.chat.preview.components.d(r80, r11, this.a);
        goto L310
    L252:
        r80 = new IGProperty(Type.CARD_CONTAINER, null);
        goto L253
    L255:
        if ((r1 instanceof EmptyProperty) == false) goto L257;
        EmptyProperty r81 = (EmptyProperty) r1;
    L258:
        String r82 = r81.getActionId();
        if (r82 != null) goto L261;
    L266:
        r10 = false;
    L267:
        if (r10 == false) goto L275;
        if (r36 == null) goto L270;
        UrlPreviewAction r83 = (UrlPreviewAction) r36.get(r81.getActionId());
    L271:
        if (r83 == null) goto L275;
        String r84 = r81.getActionId();
        if (r84 == null) goto L275;
        com.ss.android.lark.chat.preview.actions.b r85 = com.ss.android.lark.chat.preview.actions.a.a((UrlPreviewAction) r36.get(r84), r84, r37, this.a, r36);
    L313:
        return new c(r81, r11, this.a, r85, r34);
    L270:
        r83 = null;
    L275:
        r85 = null;
        goto L313
    L261:
        if (r82.length() <= 0) goto L263;
        boolean r86 = true;
    L264:
        if (r86 != true) goto L266;
    L263:
        r86 = false;
        goto L264
    L257:
        r81 = new EmptyProperty(Type.EMPTY, null, 2, null);
        goto L258
    L316:
        return null;
    L297:
        return null;
    }
}
