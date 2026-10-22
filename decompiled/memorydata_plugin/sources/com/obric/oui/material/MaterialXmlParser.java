package com.obric.oui.material;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.oui.graphic.BlendMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.FloatSpreadBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003uvwB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\fH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0002J+\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0004\"\u00020\bH\u0002¢\u0006\u0002\u0010\u0015J2\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002J)\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0004\"\u00020\bH\u0002¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0002J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010*\u001a\u00020+H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020-H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010.\u001a\u00020\bH\u0007J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010/\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0007J%\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u00101J%\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u00102J\u001d\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00103J\u001d\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-H\u0007¢\u0006\u0002\u00104J\u001d\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010.\u001a\u00020\bH\u0007¢\u0006\u0002\u00105J%\u00100\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010/\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0007¢\u0006\u0002\u00106J\u001d\u00107\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010<\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0019\u0010=\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0019\u0010B\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?J\u0019\u0010C\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?J\u0017\u0010D\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010?J\u0012\u0010G\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0019\u0010I\u001a\u0004\u0018\u00010J2\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010KJ\u0012\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001d\u0010Q\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010RJ\u001d\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010UJ\u0012\u0010V\u001a\u0004\u0018\u00010T2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J/\u0010W\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010XJ\u001c\u0010Y\u001a\u0004\u0018\u00010:2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010Z\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J;\u0010`\u001a\u0004\u0018\u0001Ha\"\u0004\b\u0000\u0010a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0014\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u0001Ha0cH\u0002¢\u0006\u0002\u0010dJ3\u0010`\u001a\u0004\u0018\u0001Ha\"\u0004\b\u0000\u0010a2\u0006\u0010*\u001a\u00020+2\u0014\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u0001Ha0cH\u0002¢\u0006\u0002\u0010eJ3\u0010`\u001a\u0004\u0018\u0001Ha\"\u0004\b\u0000\u0010a2\u0006\u0010,\u001a\u00020-2\u0014\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u0001Ha0cH\u0002¢\u0006\u0002\u0010fJ\u0012\u0010g\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002JW\u0010h\u001a\n\u0012\u0004\u0012\u0002Ha\u0018\u00010\f\"\u0004\b\u0000\u0010a2\b\u0010i\u001a\u0004\u0018\u0001Ha2\b\u0010j\u001a\u0004\u0018\u0001Ha2\b\u0010k\u001a\u0004\u0018\u0001Ha2\b\u0010l\u001a\u0004\u0018\u0001Ha2\b\u0010m\u001a\u0004\u0018\u0001Ha2\b\u0010n\u001a\u0004\u0018\u0001HaH\u0002¢\u0006\u0002\u0010oJ\u001f\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\b\u0010q\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010rJ\u0010\u0010s\u001a\u00020t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006x"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser;", "", "()V", "MATERIAL_STATE_SPECS", "", "", "[[I", "XML_SUFFIX", "", "buildBlendConfigStateList", "Lcom/obric/oui/res/BlendConfigStateList;", "values", "Lcom/obric/oui/material/MaterialXmlParser$ResolvedStatefulValues;", "Lcom/obric/oui/color/BlendConfig;", "buildColorStateList", "Landroid/content/res/ColorStateList;", "", "getAttribute", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "names", "(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;)Ljava/lang/String;", "getStatefulAttribute", "state", "Lcom/obric/oui/material/MaterialXmlParser$MaterialState;", "suffixName", "baseName", "hasAnyAttribute", "", "(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;)Z", "normalizeName", ActivityLifecycle.NAME, "normalizeXmlFileName", "fileName", "parse", "Lcom/obric/oui/material/MaterialConfig;", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "input", "Ljava/io/InputStream;", Params.FILE_PATH, "dirPath", "parseArray", "(Landroid/content/ContentResolver;Landroid/net/Uri;)[Lcom/obric/oui/material/MaterialConfig;", "(Landroid/content/Context;Landroid/net/Uri;)[Lcom/obric/oui/material/MaterialConfig;", "(Ljava/io/File;)[Lcom/obric/oui/material/MaterialConfig;", "(Ljava/io/InputStream;)[Lcom/obric/oui/material/MaterialConfig;", "(Ljava/lang/String;)[Lcom/obric/oui/material/MaterialConfig;", "(Ljava/lang/String;Ljava/lang/String;)[Lcom/obric/oui/material/MaterialConfig;", "parseBlendConfigArray", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/color/BlendConfig;", "parseBlendConfigContainer", "Lcom/obric/oui/material/MaterialXmlParser$ParsedBlendConfigContainer;", "parseBlendConfigItem", "parseBlendConfigValueFromAttributes", "parseBlendMode", EventBody.KEY_VALUE, "(Ljava/lang/String;)Ljava/lang/Integer;", "parseBlurConfig", "Lcom/obric/oui/blur/BlurConfig;", "parseBlurDirection", "parseColor", "parseColorItem", "(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/Integer;", "parseCurveType", "parseFallbackBgColorContainer", "parseFallbackBgColorFromAttributes", "parseFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "parseFluidConfig", "Lcom/obric/oui/fluid/FluidConfig;", "parseFluidParams", "", "parseMaterialConfig", "parseMaterialConfigArray", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/material/MaterialConfig;", "parseShadowArray", "Lcom/obric/oui/shadow/ShadowConfig;", "(Lorg/xmlpull/v1/XmlPullParser;)[Lcom/obric/oui/shadow/ShadowConfig;", "parseShadowItem", "parseStatefulBlendConfigValue", "(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Lcom/obric/oui/material/MaterialXmlParser$MaterialState;)[Lcom/obric/oui/color/BlendConfig;", "parseStatefulBlendConfigsFromAttributes", "parseStatefulColorsFromAttributes", "parseStroke", "Lcom/obric/oui/color/StrokeConfig;", "parseStrokeStateItem", "parseStrokeStateList", "Lcom/obric/oui/res/StrokeStateList;", "parseWithParser", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Landroid/content/ContentResolver;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/io/InputStream;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "readTextContent", "resolveStatefulValues", "normal", "pressed", "hovered", "checked", BuildConfig.FLAVOR, "disabled", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/obric/oui/material/MaterialXmlParser$ResolvedStatefulValues;", "singleBlendConfigArray", "item", "(Lcom/obric/oui/color/BlendConfig;)[Lcom/obric/oui/color/BlendConfig;", "skipCurrentTag", "", "MaterialState", "ParsedBlendConfigContainer", "ResolvedStatefulValues", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialXmlParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MaterialXmlParser f13992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f13993b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser$MaterialState;", "", "xmlName", "", "nodeName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getNodeName", "()Ljava/lang/String;", "getXmlName", "NORMAL", "PRESS", "HOVER", "CHECKED", "SELECTED", "DISABLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum MaterialState extends Enum<MaterialState> {
        private static final /* synthetic */ MaterialState[] $VALUES = null;
        public static final MaterialState CHECKED = null;
        public static final MaterialState DISABLE = null;
        public static final MaterialState HOVER = null;
        public static final MaterialState NORMAL = null;
        public static final MaterialState PRESS = null;
        public static final MaterialState SELECTED = null;
        private final String nodeName;
        private final String xmlName;

        private static final /* synthetic */ MaterialState[] $values() {
            return new MaterialState[]{NORMAL, PRESS, HOVER, CHECKED, SELECTED, DISABLE};
        }

        static {
            NORMAL = new MaterialState("NORMAL", 0, "normal", null, 2, null);
            String r12 = null;
            int r13 = 2;
            DefaultConstructorMarker r14 = null;
            PRESS = new MaterialState("PRESS", 1, "press", r12, r13, r14);
            String r5 = null;
            int r6 = 2;
            DefaultConstructorMarker r7 = null;
            HOVER = new MaterialState("HOVER", 2, "hover", r5, r6, r7);
            CHECKED = new MaterialState("CHECKED", 3, "checked", r12, r13, r14);
            SELECTED = new MaterialState("SELECTED", 4, BuildConfig.FLAVOR, r5, r6, r7);
            DISABLE = new MaterialState("DISABLE", 5, "disable", r12, r13, r14);
            $VALUES = $values();
        }

        private MaterialState(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.xmlName = r3;
            this.nodeName = r4;
        }

        /* synthetic */ MaterialState(String r1, int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L5;
            r4 = r3;
        L5:
            this(r1, r2, r3, r4);
        }

        public static MaterialState valueOf(String r2) {
            return (MaterialState) ZeusTransformUtils.preCheckCast(Enum.valueOf(MaterialState.class, r2), MaterialState.class, "com.obric.memorydata.plugin");
        }

        public static MaterialState[] values() {
            return (MaterialState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MaterialState[].class, "com.obric.memorydata.plugin");
        }

        public final String getNodeName() {
            return this.nodeName;
        }

        public final String getXmlName() {
            return this.xmlName;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J(\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser$ParsedBlendConfigContainer;", "", "defaultConfig", "", "Lcom/obric/oui/color/BlendConfig;", "stateList", "Lcom/obric/oui/res/BlendConfigStateList;", "([Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/BlendConfigStateList;)V", "getDefaultConfig", "()[Lcom/obric/oui/color/BlendConfig;", "[Lcom/obric/oui/color/BlendConfig;", "getStateList", "()Lcom/obric/oui/res/BlendConfigStateList;", "component1", "component2", "copy", "([Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/BlendConfigStateList;)Lcom/obric/oui/material/MaterialXmlParser$ParsedBlendConfigContainer;", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.oui.color.a[] f13994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.oui.b.a f13995b;

        public a(com.obric.oui.color.a[] r2, com.obric.oui.b.a r3) {
            Intrinsics.checkNotNullParameter(r2, "defaultConfig");
            Intrinsics.checkNotNullParameter(r3, "stateList");
            this.f13994a = r2;
            this.f13995b = r3;
        }

        public final com.obric.oui.color.a[] a() {
            return this.f13994a;
        }

        public final com.obric.oui.b.a b() {
            return this.f13995b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13994a, r6.f13994a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13995b, r6.f13995b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f13994a) * 31) + this.f13995b.hashCode();
        }

        public String toString() {
            return "ParsedBlendConfigContainer(defaultConfig=" + Arrays.toString(this.f13994a) + ", stateList=" + this.f13995b + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ \u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u0016\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0017\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0018\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0019\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001a\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJP\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser$ResolvedStatefulValues;", ExifInterface.GPS_DIRECTION_TRUE, "", "normal", "pressed", "hovered", "checked", BuildConfig.FLAVOR, "disabled", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getChecked", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDisabled", "getHovered", "getNormal", "getPressed", "getSelected", "allEqual", "", "comparator", "Lkotlin/Function2;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/obric/oui/material/MaterialXmlParser$ResolvedStatefulValues;", "equals", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f13996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f13997b;
        private final T c;
        private final T d;
        private final T e;
        private final T f;

        public b(T r1, T r2, T r3, T r4, T r5, T r6) {
            this.f13996a = r1;
            this.f13997b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final T a() {
            return this.f13996a;
        }

        public final boolean a(Function2<? super T, ? super T, Boolean> r4) {
            Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "comparator");
            if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(this.f13996a, this.f13997b), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        L13:
            return false;
        L5:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(this.f13996a, this.c), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L13;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(this.f13996a, this.d), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L13;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(this.f13996a, this.e), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L13;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(this.f13996a, this.f), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L13;
            return true;
        }

        public final T b() {
            return this.f13997b;
        }

        public final T c() {
            return this.c;
        }

        public final T d() {
            return this.d;
        }

        public final T e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13996a, r6.f13996a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13997b, r6.f13997b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final T f() {
            return this.f;
        }

        public int hashCode() {
            T r0 = this.f13996a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            T r4 = this.f13997b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            T r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            T r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            T r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ResolvedStatefulValues(normal=" + this.f13996a + ", pressed=" + this.f13997b + ", hovered=" + this.c + ", checked=" + this.d + ", selected=" + this.e + ", disabled=" + this.f + ')';
        }
    }

    static {
        f13992a = new MaterialXmlParser();
        f13993b = new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    private MaterialXmlParser() {
    }

    private final ColorStateList a(b<Integer> r7) {
        if (r7.a((Function2) ZeusTransformUtils.preCheckCast(MaterialXmlParser$buildColorStateList$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin")) == false) goto L7;
        ColorStateList r6 = ColorStateList.valueOf(((Number) ZeusTransformUtils.preCheckCast(r7.a(), Number.class, "com.obric.memorydata.plugin")).intValue());
        Intrinsics.checkNotNullExpressionValue(r6, "valueOf(values.normal)");
        return r6;
    L7:
        return new ColorStateList(f13993b, new int[]{((Number) ZeusTransformUtils.preCheckCast(r7.d(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.d(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.e(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.e(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.e(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.e(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.b(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.c(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.d(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.e(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.f(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.a(), Number.class, "com.obric.memorydata.plugin")).intValue()});
    }

    private final a a(XmlPullParser r10, String r11) {
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r10, XmlPullParser.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        b<com.obric.oui.color.a[]> r13 = a(a(r12, r11, MaterialState.NORMAL), a(r12, r11, MaterialState.PRESS), a(r12, r11, MaterialState.HOVER), a(r12, r11, MaterialState.CHECKED), a(r12, r11, MaterialState.SELECTED), a(r12, r11, MaterialState.DISABLE));
        if (r13 != null) goto L10;
        return null;
    L10:
        com.obric.oui.b.a r9 = b(r13);
        return new a(r9.a(), r9);
    L6:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        goto L4
    }

    private final <T> b<T> a(T r8, T r9, T r10, T r11, T r12, T r13) {
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r9 != null) goto L7;
        T r2 = r8;
    L8:
        if (r10 != null) goto L10;
        T r3 = r2;
    L12:
        if (r11 != null) goto L14;
        T r4 = r8;
    L15:
        if (r12 != null) goto L17;
        T r5 = r8;
    L18:
        if (r13 != null) goto L20;
        T r6 = r8;
    L22:
        return new b(r8, r2, r3, r4, r5, r6);
    L20:
        r6 = r13;
        goto L22
    L17:
        r5 = r12;
        goto L18
    L14:
        r4 = r11;
        goto L15
    L10:
        r3 = r10;
        goto L12
    L7:
        r2 = r9;
        goto L8
    }

    public static final /* synthetic */ c a(MaterialXmlParser r2, XmlPullParser r3) {
        return r2.a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"));
    }

    private final c a(XmlPullParser r15) {
        XmlPullParser r16 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r15, XmlPullParser.class, "com.obric.memorydata.plugin");
        c r13 = new c(n(r16), null, null, null, null, null, null, b(a(r16, new String[]{"blur_radius"})), null, null, 894, null);
        a r1 = a(r16, "blend_configs");
        if (r1 == null) goto L6;
        r13.a(r1.a());
        r13.a(r1.b());
    L6:
        int r2 = r16.getDepth();
    L7:
        int r3 = r16.next();
        if (r3 == 1) goto L75;
        if (r3 != 2) goto L12;
        String r4 = r16.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "parser.name");
        String r5 = f(r4);
        switch(r5.hashCode()) {
            case -1622636237: goto L69;
            case -1115483408: goto L61;
            case -891980232: goto L57;
            case -220247165: goto L44;
            case 97532362: goto L40;
            case 737726312: goto L33;
            case 1690590746: goto L29;
            case 1873723302: goto L25;
            case 2053811027: goto L21;
            default: goto L74;
        };
    L25:
        if (r5.equals("fallback_bg_color") == false) goto L74;
        r13.a(o(r16));
        goto L7
    L29:
        if (r5.equals("blur_config") == false) goto L74;
        r13.a(i(r16));
        goto L7
    L33:
        if (r5.equals("stroke_statelist") == false) goto L74;
        com.obric.oui.b.c r6 = g(r16);
        if (r6 == null) goto L7;
        r13.a(r6);
        goto L7
    L40:
        if (r5.equals("fluid") == false) goto L74;
        r13.a(l(r16));
        goto L7
    L44:
        if (r5.equals("blend_configs") == false) goto L74;
        a r7 = d(r16);
        com.obric.oui.b.a r8 = null;
        if (r7 != null) goto L49;
        com.obric.oui.color.a[] r9 = null;
    L50:
        r13.a(r9);
        if (r7 == null) goto L54;
        r8 = r7.b();
    L54:
        if (r8 == null) goto L7;
        r13.a(r7.b());
        goto L7
    L49:
        r9 = r7.a();
        goto L50
    L57:
        if (r5.equals("stroke") == false) goto L74;
        r13.a(f(r16));
        goto L7
    L61:
        if (r5.equals("blend_config") == false) goto L74;
        if (b(r16, new String[]{TypedValues.Custom.S_COLOR}) == false) goto L66;
        com.obric.oui.color.a[] r10 = a(e(r16));
    L67:
        r13.a(r10);
        goto L7
    L66:
        r10 = c(r16);
        goto L67
    L69:
        if (r5.equals("overlayblend_configs") == false) goto L74;
        a r11 = d(r16);
        if (r11 == null) goto L7;
        r13.b(r11.b());
    L74:
        r(r16);
        goto L7
    L21:
        if (r5.equals("shadows") == false) goto L74;
        r13.a(j(r16));
        goto L7
    L12:
        if (r3 != 3) goto L7;
        if (r16.getDepth() != r2) goto L7;
        return r13;
    L75:
        return r13;
    }

    private final Integer a(String r6) {
        if (r6 != null) goto L5;
    L4:
        String r7 = null;
    L13:
        if (r7 != null) goto L32;
        return null;
    L32:
        if (StringsKt.startsWith$default(r7, "#", false, 2, null) == false) goto L19;
    L17:
        int r5 = Color.parseColor(r7);     // Catch: Throwable -> L30
    L28:
        return Integer.valueOf(r5);
    L19:
        if (StringsKt.startsWith(r7, "0x", true) == false) goto L21;
        String r8 = r7.substring(2);     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L30
        r5 = (int) Long.parseLong(r8, CharsKt.checkRadix(16));     // Catch: Throwable -> L30
        goto L28
    L21:
        Long r9 = StringsKt.toLongOrNull(r7);     // Catch: Throwable -> L30
        if (r9 != null) goto L24;
        Integer r10 = null;
    L25:
        if (r10 == null) goto L17;
        r5 = r10.intValue();     // Catch: Throwable -> L30
        goto L28
    L24:
        r10 = Integer.valueOf((int) r9.longValue());     // Catch: Throwable -> L30
    L31:
        return (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.memorydata.plugin");
    L5:
        r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r7 == null) goto L4;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L4;
    L11:
        r3 = false;
        goto L12
    }

    public static final /* synthetic */ String a(MaterialXmlParser r0, String r1) {
        return r0.f(r1);
    }

    static /* synthetic */ String a(MaterialXmlParser r1, XmlPullParser r2, MaterialState r3, String r4, String r5, int r6, Object r7) {
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r2, XmlPullParser.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.a(r8, r3, r4, r5);
    }

    private final String a(XmlPullParser r6, MaterialState r7, String r8, String r9) {
        XmlPullParser r10 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlPullParser.class, "com.obric.memorydata.plugin");
        String r11 = r7.getXmlName();
        List r0 = CollectionsKt.createListBuilder();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == true) goto L15;
        r0.add(r9 + '_' + r11);
        if (r8 == null) goto L15;
        r0.add(r9 + '_' + r11 + '_' + r8);
    L15:
        if (r8 == null) goto L18;
        r0.add(r11 + '_' + r8);
    L18:
        if (r8 != null) goto L20;
        r0.add(r11);
    L20:
        Object[] r12 = ((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r0), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Objects.requireNonNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] r13 = (String[]) ZeusTransformUtils.preCheckCast(r12, String[].class, "com.obric.memorydata.plugin");
        return a(r10, (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r13, r13.length), String[].class, "com.obric.memorydata.plugin"));
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L10
    }

    private final String a(XmlPullParser r8, String... r9) {
        XmlPullParser r7 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (r9.length != 0) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L9;
        return null;
    L9:
        Set r11 = ArraysKt.toSet(r9);
        int r12 = r7.getAttributeCount();
        int r4 = 0;
    L10:
        if (r4 >= r12) goto L30;
        int r5 = r4 + 1;
        String r6 = r7.getAttributeName(r4);
        if (r6 == null) goto L29;
        if (r11.contains(r6) == false) goto L29;
        String r13 = r7.getAttributeValue(r4);
        if (r13 == null) goto L36;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r14 != null) goto L23;
        return null;
    L23:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L26;
        r1 = false;
    L26:
        if (r1 == true) goto L28;
        return null;
    L28:
        return r14;
    L36:
        return null;
    L29:
        r4 = r5;
        goto L10
    L30:
        return null;
    L5:
        r10 = false;
        goto L7
    }

    private final com.obric.oui.color.a[] a(com.obric.oui.color.a r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return new com.obric.oui.color.a[]{r2};
    }

    private final com.obric.oui.color.a[] a(XmlPullParser r3, String r4, MaterialState r5) {
        com.obric.oui.color.a r2 = b((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), r4, r5);
        if (r2 != null) goto L6;
        return null;
    L6:
        return new com.obric.oui.color.a[]{r2};
    }

    private final com.obric.oui.b.a b(b<com.obric.oui.color.a[]> r7) {
        if (r7.a((Function2) ZeusTransformUtils.preCheckCast(MaterialXmlParser$buildBlendConfigStateList$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return com.obric.oui.b.a.f13317a.a((com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.a(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"));
    L7:
        return com.obric.oui.b.a.f13317a.a(f13993b, new com.obric.oui.color.a[][]{(com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.d(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.d(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.e(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.e(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.e(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.e(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.c(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.d(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.e(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.f(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin"), (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r7.a(), com.obric.oui.color.a[].class, "com.obric.memorydata.plugin")});
    }

    private final com.obric.oui.color.a b(XmlPullParser r3, String r4, MaterialState r5) {
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        Integer r0 = a(a(r6, r5, TypedValues.Custom.S_COLOR, r4));
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.intValue();
        Integer r2 = c(a(r6, r5, "blend_mode", r4));
        if (r2 != null) goto L9;
        int r7 = BlendMode.SRC_OVER.porterDuffMode;
    L11:
        return new com.obric.oui.color.a(r1, r7);
    L9:
        r7 = r2.intValue();
        goto L11
    }

    private final Float b(String r3) {
        if (r3 != null) goto L5;
    L4:
        String r4 = null;
    L13:
        if (r4 != null) goto L16;
        return null;
    L16:
        return StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(r4, (CharSequence) ZeusTransformUtils.preCheckCast("dp", CharSequence.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("px", CharSequence.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("sp", CharSequence.class, "com.obric.memorydata.plugin")));
    L5:
        r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r4 == null) goto L4;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L4;
    L11:
        r1 = false;
        goto L12
    }

    private final boolean b(XmlPullParser r3, String... r4) {
        if (a((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), String[].class, "com.obric.memorydata.plugin")) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ c[] b(MaterialXmlParser r2, XmlPullParser r3) {
        return r2.b((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"));
    }

    private final c[] b(XmlPullParser r7) {
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        int r2 = r8.getDepth();
    L3:
        int r3 = r8.next();
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L8;
        String r4 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "parser.name");
        if (Intrinsics.areEqual(f(r4), "material_config") == true) goto L15;
        r(r8);
        goto L3
    L15:
        r0.add(a(r8));
        goto L3
    L8:
        if (r3 != 3) goto L3;
        if (r8.getDepth() != r2) goto L3;
    L17:
        boolean r9 = false;
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).toArray(new c[0]);
        Objects.requireNonNull(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        if (((c[]) ZeusTransformUtils.preCheckCast(r6, c[].class, "com.obric.memorydata.plugin")).length != 0) goto L21;
        r9 = true;
    L21:
        if ((!r9) == true) goto L25;
        r6 = null;
    L25:
        return (c[]) ZeusTransformUtils.preCheckCast(r6, c[].class, "com.obric.memorydata.plugin");
    }

    private final Integer c(String r8) {
        int r0 = 0;
        if (r8 != null) goto L5;
    L4:
        String r9 = null;
    L13:
        if (r9 != null) goto L15;
        return null;
    L15:
        Integer r3 = StringsKt.toIntOrNull(r9);
        if (r3 != null) goto L29;
        String r7 = f(r9).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        BlendMode[] r1 = BlendMode.values();
        int r4 = r1.length;
    L18:
        if (r0 >= r4) goto L23;
        BlendMode r5 = r1[r0];
        String r6 = f13992a.f(r5.name()).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (Intrinsics.areEqual(r6, r7) == true) goto L24;
        r0 = r0 + 1;
    L24:
        if (r5 != null) goto L27;
        return null;
    L27:
        return Integer.valueOf(r5.porterDuffMode);
    L23:
        r5 = null;
        goto L24
    L29:
        return Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
    L5:
        r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r9 == null) goto L4;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L4;
    L11:
        r10 = false;
        goto L12
    }

    private final com.obric.oui.color.a[] c(XmlPullParser r7) {
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        int r2 = r8.getDepth();
    L3:
        int r3 = r8.next();
        if (r3 == 1) goto L20;
        if (r3 != 2) goto L8;
        String r4 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "parser.name");
        if (Intrinsics.areEqual(f(r4), "blend_config") == true) goto L15;
        r(r8);
        goto L3
    L15:
        com.obric.oui.color.a r5 = e(r8);
        if (r5 == null) goto L3;
        r0.add(r5);
        goto L3
    L8:
        if (r3 != 3) goto L3;
        if (r8.getDepth() != r2) goto L3;
    L20:
        boolean r9 = false;
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).toArray(new com.obric.oui.color.a[0]);
        Objects.requireNonNull(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        if (((com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r6, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin")).length != 0) goto L24;
        r9 = true;
    L24:
        if ((!r9) == true) goto L28;
        r6 = null;
    L28:
        return (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r6, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin");
    }

    private final a d(XmlPullParser r14) {
        XmlPullParser r15 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r14, XmlPullParser.class, "com.obric.memorydata.plugin");
        a r2 = a(r15, null);
        if (r2 == null) goto L5;
        f13992a.r(r15);
        return r2;
    L5:
        if (b(r15, new String[]{TypedValues.Custom.S_COLOR}) == false) goto L11;
        com.obric.oui.color.a[] r13 = a(e(r15));
        if (r13 != null) goto L10;
        return null;
    L10:
        return new a(r13, com.obric.oui.b.a.f13317a.a(r13));
    L11:
        ArrayList r3 = new ArrayList();
        int r4 = r15.getDepth();
        com.obric.oui.color.a[] r5 = null;
        com.obric.oui.color.a[] r7 = null;
        com.obric.oui.color.a[] r8 = null;
        com.obric.oui.color.a[] r9 = null;
        com.obric.oui.color.a[] r10 = null;
        com.obric.oui.color.a[] r11 = null;
    L12:
        int r6 = r15.next();
        if (r6 == 1) goto L47;
        if (r6 != 2) goto L17;
        String r12 = r15.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "parser.name");
        String r16 = f(r12);
        if (Intrinsics.areEqual(r16, "blend_config") == true) goto L24;
        if (Intrinsics.areEqual(r16, MaterialState.NORMAL.getNodeName()) == true) goto L30;
        if (Intrinsics.areEqual(r16, MaterialState.PRESS.getNodeName()) == true) goto L33;
        if (Intrinsics.areEqual(r16, MaterialState.HOVER.getNodeName()) == true) goto L36;
        if (Intrinsics.areEqual(r16, MaterialState.CHECKED.getNodeName()) == true) goto L39;
        if (Intrinsics.areEqual(r16, MaterialState.SELECTED.getNodeName()) == true) goto L42;
        if (Intrinsics.areEqual(r16, MaterialState.DISABLE.getNodeName()) == true) goto L45;
        r(r15);
        goto L12
    L45:
        r11 = c(r15);
        goto L12
    L42:
        r10 = c(r15);
        goto L12
    L39:
        r9 = c(r15);
        goto L12
    L36:
        r8 = c(r15);
        goto L12
    L33:
        r7 = c(r15);
        goto L12
    L30:
        r5 = c(r15);
        goto L12
    L24:
        com.obric.oui.color.a r17 = e(r15);
        if (r17 == null) goto L12;
        r3.add(r17);
        goto L12
    L17:
        if (r6 != 3) goto L12;
        if (r15.getDepth() != r4) goto L12;
    L47:
        boolean r18 = false;
        if (r5 == null) goto L50;
    L52:
        b<com.obric.oui.color.a[]> r19 = a(r5, r7, r8, r9, r10, r11);
        if (r19 == null) goto L56;
        com.obric.oui.b.a r110 = b(r19);
        return new a(r110.a(), r110);
    L56:
        Object[] r111 = ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).toArray(new com.obric.oui.color.a[0]);
        Objects.requireNonNull(r111, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        if (((com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r111, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin")).length != 0) goto L60;
        r18 = true;
    L60:
        if ((!r18) == true) goto L63;
        r111 = null;
    L63:
        com.obric.oui.color.a[] r112 = (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r111, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L67;
        return null;
    L67:
        return new a(r112, com.obric.oui.b.a.f13317a.a(r112));
    L50:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L52;
        Object[] r20 = ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).toArray(new com.obric.oui.color.a[0]);
        Objects.requireNonNull(r20, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r5 = (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r20, com.obric.oui.color.a[].class, "com.obric.memorydata.plugin");
        goto L52
    }

    private final Integer d(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r1 = f(r2);
        switch(r1.hashCode()) {
            case -1372950257: goto L29;
            case -1039745817: goto L25;
            case -885896177: goto L21;
            case -149309725: goto L17;
            case 3387192: goto L13;
            case 818060433: goto L9;
            default: goto L34;
        };
    L9:
        if (r1.equals("progress_rightleft") == false) goto L34;
        int r3 = 4;
    L35:
        return Integer.valueOf(r3);
    L13:
        if (r1.equals("none") == false) goto L34;
        r3 = -1;
        goto L35
    L17:
        if (r1.equals("progress_leftright") == false) goto L34;
        r3 = 3;
        goto L35
    L21:
        if (r1.equals("progress_updown") == false) goto L34;
        r3 = 2;
        goto L35
    L25:
        if (r1.equals("normal") == false) goto L34;
        r3 = 0;
        goto L35
    L29:
        if (r1.equals("progress_downup") == false) goto L34;
        r3 = 1;
    L34:
        return StringsKt.toIntOrNull(r2);
    }

    private final com.obric.oui.color.a e(XmlPullParser r3) {
        XmlPullParser r4 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        Integer r0 = a(a(r4, new String[]{TypedValues.Custom.S_COLOR}));
        if (r0 != null) goto L6;
        ((MaterialXmlParser) ZeusTransformUtils.preCheckCast(this, MaterialXmlParser.class, "com.obric.memorydata.plugin")).r(r4);
        return null;
    L6:
        int r1 = r0.intValue();
        Integer r2 = c(a(r4, new String[]{"blend_mode"}));
        if (r2 != null) goto L9;
        int r5 = BlendMode.SRC_OVER.porterDuffMode;
    L10:
        r(r4);
        return new com.obric.oui.color.a(r1, r5);
    L9:
        r5 = r2.intValue();
        goto L10
    }

    private final Integer e(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r1 = f(r2);
        switch(r1.hashCode()) {
            case -1102672091: goto L33;
            case -356211779: goto L29;
            case -32570448: goto L25;
            case 54365080: goto L21;
            case 1672389401: goto L17;
            case 1829408660: goto L13;
            case 1939029025: goto L9;
            default: goto L38;
        };
    L9:
        if (r1.equals("in_quad") == false) goto L38;
        int r3 = 1;
    L39:
        return Integer.valueOf(r3);
    L13:
        if (r1.equals("inout_cubic") == false) goto L38;
        r3 = 6;
        goto L39
    L17:
        if (r1.equals("out_cubic") == false) goto L38;
        r3 = 5;
        goto L39
    L21:
        if (r1.equals("out_quad") == false) goto L38;
        r3 = 2;
        goto L39
    L25:
        if (r1.equals("in_cubic") == false) goto L38;
        r3 = 4;
        goto L39
    L29:
        if (r1.equals("inout_quad") == false) goto L38;
        r3 = 3;
        goto L39
    L33:
        if (r1.equals("linear") == false) goto L38;
        r3 = 0;
    L38:
        return StringsKt.toIntOrNull(r2);
    }

    private final com.obric.oui.color.e f(XmlPullParser r9) {
        XmlPullParser r10 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
        Float r0 = b(a(r10, new String[]{"width"}));
        Integer r2 = a(a(r10, new String[]{TypedValues.Custom.S_COLOR}));
        Integer r3 = c(a(r10, new String[]{"blend_mode"}));
        r(r10);
        BlendMode r8 = null;
        if (r0 == null) goto L22;
        if (r2 == null) goto L22;
        float r11 = r0.floatValue();
        int r1 = r2.intValue();
        if (r3 == null) goto L18;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        BlendMode[] r5 = BlendMode.values();
        int r6 = r5.length;
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L18;
        BlendMode r12 = r5[r7];
        if (r12.porterDuffMode != r4) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == true) goto L16;
        r7 = r7 + 1;
        goto L10
    L16:
        r8 = r12;
        goto L18
    L14:
        r13 = false;
    L18:
        if (r8 != null) goto L21;
        r8 = BlendMode.SRC_OVER;
    L21:
        return new com.obric.oui.color.e(r11, r1, r8);
    L22:
        return null;
    }

    private final String f(String r7) {
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r0, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return StringsKt.replace$default(r0, '-', '_', false, 4, null);
    }

    private final com.obric.oui.b.c g(XmlPullParser r13) {
        XmlPullParser r14 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.memorydata.plugin");
        if (b(r14, new String[]{"width", TypedValues.Custom.S_COLOR}) == false) goto L9;
        com.obric.oui.color.e r12 = f(r14);
        if (r12 != null) goto L8;
        return null;
    L8:
        return com.obric.oui.b.c.f13321a.a(r12);
    L9:
        int r0 = r14.getDepth();
        com.obric.oui.color.e r3 = null;
        com.obric.oui.color.e r4 = null;
        com.obric.oui.color.e r7 = null;
        com.obric.oui.color.e r8 = null;
        com.obric.oui.color.e r9 = null;
        com.obric.oui.color.e r10 = null;
        com.obric.oui.color.e r11 = null;
    L10:
        int r5 = r14.next();
        if (r5 == 1) goto L42;
        if (r5 != 2) goto L15;
        String r6 = r14.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "parser.name");
        String r15 = f(r6);
        if (Intrinsics.areEqual(r15, "stroke") == true) goto L22;
        if (Intrinsics.areEqual(r15, MaterialState.NORMAL.getNodeName()) == true) goto L25;
        if (Intrinsics.areEqual(r15, MaterialState.PRESS.getNodeName()) == true) goto L28;
        if (Intrinsics.areEqual(r15, MaterialState.HOVER.getNodeName()) == true) goto L31;
        if (Intrinsics.areEqual(r15, MaterialState.CHECKED.getNodeName()) == true) goto L34;
        if (Intrinsics.areEqual(r15, MaterialState.SELECTED.getNodeName()) == true) goto L37;
        if (Intrinsics.areEqual(r15, MaterialState.DISABLE.getNodeName()) == true) goto L40;
        r(r14);
        goto L10
    L40:
        r11 = h(r14);
        goto L10
    L37:
        r10 = h(r14);
        goto L10
    L34:
        r9 = h(r14);
        goto L10
    L31:
        r8 = h(r14);
        goto L10
    L28:
        r7 = h(r14);
        goto L10
    L25:
        r3 = h(r14);
        goto L10
    L22:
        r4 = f(r14);
        goto L10
    L15:
        if (r5 != 3) goto L10;
        if (r14.getDepth() != r0) goto L10;
    L42:
        if (r3 != null) goto L44;
        com.obric.oui.color.e r16 = r4;
    L45:
        b r17 = a(r16, r7, r8, r9, r10, r11);
        if (r17 != null) goto L49;
        return null;
    L49:
        return com.obric.oui.b.c.a.a(com.obric.oui.b.c.f13321a, (com.obric.oui.color.e) ZeusTransformUtils.preCheckCast(r17.a(), com.obric.oui.color.e.class, "com.obric.memorydata.plugin"), null, (com.obric.oui.color.e) ZeusTransformUtils.preCheckCast(r17.d(), com.obric.oui.color.e.class, "com.obric.memorydata.plugin"), (com.obric.oui.color.e) ZeusTransformUtils.preCheckCast(r17.b(), com.obric.oui.color.e.class, "com.obric.memorydata.plugin"), (com.obric.oui.color.e) ZeusTransformUtils.preCheckCast(r17.c(), com.obric.oui.color.e.class, "com.obric.memorydata.plugin"), (com.obric.oui.color.e) ZeusTransformUtils.preCheckCast(r17.f(), com.obric.oui.color.e.class, "com.obric.memorydata.plugin"), 2, null);
    L44:
        r16 = r3;
        goto L45
    }

    private final com.obric.oui.color.e h(XmlPullParser r6) {
        XmlPullParser r7 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlPullParser.class, "com.obric.memorydata.plugin");
        if (b(r7, new String[]{"width", TypedValues.Custom.S_COLOR}) == true) goto L5;
        int r0 = r7.getDepth();
    L7:
        int r2 = r7.next();
        if (r2 == 1) goto L22;
        if (r2 == 2) goto L17;
        if (r2 != 3) goto L7;
        if (r7.getDepth() != r0) goto L7;
        return null;
    L17:
        String r1 = r7.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "parser.name");
        if (Intrinsics.areEqual(f(r1), "stroke") == true) goto L30;
        r(r7);
        return (com.obric.oui.color.e) ZeusTransformUtils.preCheckCast(null, com.obric.oui.color.e.class, "com.obric.memorydata.plugin");
    L30:
        return f(r7);
    L22:
        return null;
    L5:
        return f(r7);
    }

    private final com.obric.oui.blur.a i(XmlPullParser r10) {
        XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r10, XmlPullParser.class, "com.obric.memorydata.plugin");
        Float r0 = b(a(r11, new String[]{"blur_radius"}));
        Integer r1 = d(a(r11, new String[]{"direction"}));
        int r2 = 0;
        if (r1 != null) goto L5;
        int r5 = 0;
    L6:
        Float r3 = b(a(r11, new String[]{"alpha"}));
        if (r3 != null) goto L9;
        float r6 = 1.0f;
    L10:
        Integer r4 = e(a(r11, new String[]{"curve_type"}));
        if (r4 == null) goto L14;
        r2 = r4.intValue();
    L14:
        int r7 = r2;
        Float r8 = b(a(r11, new String[]{"end_point"}));
        if (r8 != null) goto L17;
        float r9 = 1.0f;
    L18:
        r(r11);
        if (r0 != null) goto L23;
        return null;
    L23:
        return new com.obric.oui.blur.a(r0.floatValue(), r5, r6, r7, r9);
    L17:
        r9 = r8.floatValue();
        goto L18
    L9:
        r6 = r3.floatValue();
        goto L10
    L5:
        r5 = r1.intValue();
        goto L6
    }

    private final com.obric.oui.shadow.a[] j(XmlPullParser r7) {
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        int r2 = r8.getDepth();
    L3:
        int r3 = r8.next();
        if (r3 == 1) goto L20;
        if (r3 != 2) goto L8;
        String r4 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "parser.name");
        if (Intrinsics.areEqual(f(r4), "shadow") == true) goto L15;
        r(r8);
        goto L3
    L15:
        com.obric.oui.shadow.a r5 = k(r8);
        if (r5 == null) goto L3;
        r0.add(r5);
        goto L3
    L8:
        if (r3 != 3) goto L3;
        if (r8.getDepth() != r2) goto L3;
    L20:
        boolean r9 = false;
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).toArray(new com.obric.oui.shadow.a[0]);
        Objects.requireNonNull(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        if (((com.obric.oui.shadow.a[]) ZeusTransformUtils.preCheckCast(r6, com.obric.oui.shadow.a[].class, "com.obric.memorydata.plugin")).length != 0) goto L24;
        r9 = true;
    L24:
        if ((!r9) == true) goto L28;
        r6 = null;
    L28:
        return (com.obric.oui.shadow.a[]) ZeusTransformUtils.preCheckCast(r6, com.obric.oui.shadow.a[].class, "com.obric.memorydata.plugin");
    }

    private final com.obric.oui.shadow.a k(XmlPullParser r10) {
        XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r10, XmlPullParser.class, "com.obric.memorydata.plugin");
        Integer r0 = a(a(r11, new String[]{TypedValues.Custom.S_COLOR}));
        if (r0 != null) goto L6;
        ((MaterialXmlParser) ZeusTransformUtils.preCheckCast(this, MaterialXmlParser.class, "com.obric.memorydata.plugin")).r(r11);
        return null;
    L6:
        int r4 = r0.intValue();
        Float r1 = b(a(r11, new String[]{"x"}));
        if (r1 != null) goto L9;
        float r2 = 0.0f;
    L10:
        Float r3 = b(a(r11, new String[]{"y"}));
        if (r3 != null) goto L13;
        float r5 = 0.0f;
    L14:
        Float r6 = b(a(r11, new String[]{"blur_radius"}));
        if (r6 != null) goto L17;
        float r7 = 0.0f;
    L18:
        Float r8 = b(a(r11, new String[]{"spread"}));
        if (r8 != null) goto L21;
        float r9 = 0.0f;
    L22:
        Integer r12 = c(a(r11, new String[]{"blend_mode"}));
        if (r12 != null) goto L25;
        int r13 = -1;
    L26:
        com.obric.oui.shadow.a r14 = new com.obric.oui.shadow.a(r2, r5, r7, r4, r9, r13);
        r(r11);
        return r14;
    L25:
        r13 = r12.intValue();
        goto L26
    L21:
        r9 = r8.floatValue();
        goto L22
    L17:
        r7 = r6.floatValue();
        goto L18
    L13:
        r5 = r3.floatValue();
        goto L14
    L9:
        r2 = r1.floatValue();
        goto L10
    }

    private final com.obric.oui.fluid.a l(XmlPullParser r3) {
        XmlPullParser r4 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        float[] r0 = m(r4);
        r(r4);
        return new com.obric.oui.fluid.a(r0);
    }

    private final float[] m(XmlPullParser r11) {
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.memorydata.plugin");
        Float r0 = b(a(r12, new String[]{"refraction_height"}));
        if (r0 != null) goto L5;
        return null;
    L5:
        float r1 = r0.floatValue();
        Float r2 = b(a(r12, new String[]{"refraction_strength"}));
        if (r2 != null) goto L8;
        return null;
    L8:
        float r3 = r2.floatValue();
        Float r4 = b(a(r12, new String[]{"highlight_angle"}));
        if (r4 != null) goto L11;
        return null;
    L11:
        float r5 = r4.floatValue();
        Float r6 = b(a(r12, new String[]{"highlight_falloff"}));
        if (r6 != null) goto L14;
        return null;
    L14:
        float r7 = r6.floatValue();
        Float r8 = b(a(r12, new String[]{"highlight_width"}));
        if (r8 != null) goto L17;
        return null;
    L17:
        float r9 = r8.floatValue();
        Float r10 = b(a(r12, new String[]{"highlight_alpha"}));
        if (r10 != null) goto L20;
        return null;
    L20:
        float r13 = r10.floatValue();
        Float r14 = b(a(r12, new String[]{"highlight_inset"}));
        if (r14 != null) goto L23;
        return null;
    L23:
        float r15 = r14.floatValue();
        Float r16 = b(a(r12, new String[]{"highlight_strength"}));
        if (r16 != null) goto L26;
        return null;
    L26:
        int r17 = 0;
        float[] r18 = {r1, r3, r5, r7, r9, r13, r15, r16.floatValue()};
        Integer r19 = a(a(r12, new String[]{"first_layer_highlight_color"}));
        Integer r20 = c(a(r12, new String[]{"first_layer_highlight_blend_mode"}));
        Integer r21 = a(a(r12, new String[]{"second_layer_highlight_color"}));
        Integer r22 = c(a(r12, new String[]{"second_layer_highlight_blend_mode"}));
        Float r110 = b(a(r12, new String[]{"chromatic_aberration"}));
        if (r19 != null) goto L32;
        if (r20 != null) goto L32;
        if (r21 != null) goto L32;
        if (r22 != null) goto L32;
        if (r110 != null) goto L32;
        return r18;
    L32:
        FloatSpreadBuilder r111 = new FloatSpreadBuilder(6);
        r111.addSpread(r18);
        FloatCompanionObject r23 = FloatCompanionObject.INSTANCE;
        if (r19 != null) goto L35;
        int r24 = 0;
    L36:
        r111.add(Float.intBitsToFloat(r24));
        if (r20 != null) goto L39;
        int r25 = BlendMode.SRC_OVER.porterDuffMode;
    L40:
        r111.add(r25);
        FloatCompanionObject r26 = FloatCompanionObject.INSTANCE;
        if (r21 == null) goto L44;
        r17 = r21.intValue();
    L44:
        r111.add(Float.intBitsToFloat(r17));
        if (r22 != null) goto L47;
        int r27 = BlendMode.SRC_OVER.porterDuffMode;
    L48:
        r111.add(r27);
        if (r110 != null) goto L51;
        float r112 = 0.0f;
    L52:
        r111.add(r112);
        return r111.toArray();
    L51:
        r112 = r110.floatValue();
        goto L52
    L47:
        r27 = r22.intValue();
        goto L48
    L39:
        r25 = r20.intValue();
        goto L40
    L35:
        r24 = r19.intValue();
        goto L36
    }

    private final ColorStateList n(XmlPullParser r13) {
        XmlPullParser r14 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.memorydata.plugin");
        Integer r0 = a(a(this, r14, MaterialState.NORMAL, null, "fallback_bg_color", 4, null));
        if (r0 != null) goto L5;
        r0 = a(a(r14, new String[]{"fallback_bg_color"}));
    L5:
        b<Integer> r15 = a(r0, a(a(this, r14, MaterialState.PRESS, null, "fallback_bg_color", 4, null)), a(a(this, r14, MaterialState.HOVER, null, "fallback_bg_color", 4, null)), a(a(this, r14, MaterialState.CHECKED, null, "fallback_bg_color", 4, null)), a(a(this, r14, MaterialState.SELECTED, null, "fallback_bg_color", 4, null)), a(a(this, r14, MaterialState.DISABLE, null, "fallback_bg_color", 4, null)));
        if (r15 != null) goto L9;
        return null;
    L9:
        return a(r15);
    }

    private final ColorStateList o(XmlPullParser r11) {
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.memorydata.plugin");
        ColorStateList r0 = p(r12);
        if (r0 != null) goto L46;
        Integer r1 = a(a(r12, new String[]{TypedValues.Custom.S_COLOR}));
        if (r1 == null) goto L8;
        r(r12);
        return ColorStateList.valueOf(r1.intValue());
    L8:
        int r2 = r12.getDepth();
        Integer r3 = null;
        Integer r5 = null;
        Integer r6 = null;
        Integer r7 = null;
        Integer r8 = null;
        Integer r9 = null;
    L9:
        int r4 = r12.next();
        if (r4 == 1) goto L38;
        if (r4 != 2) goto L14;
        String r10 = r12.getName();
        Intrinsics.checkNotNullExpressionValue(r10, "parser.name");
        String r13 = f(r10);
        if (Intrinsics.areEqual(r13, MaterialState.NORMAL.getNodeName()) == true) goto L21;
        if (Intrinsics.areEqual(r13, MaterialState.PRESS.getNodeName()) == true) goto L24;
        if (Intrinsics.areEqual(r13, MaterialState.HOVER.getNodeName()) == true) goto L27;
        if (Intrinsics.areEqual(r13, MaterialState.CHECKED.getNodeName()) == true) goto L30;
        if (Intrinsics.areEqual(r13, MaterialState.SELECTED.getNodeName()) == true) goto L33;
        if (Intrinsics.areEqual(r13, MaterialState.DISABLE.getNodeName()) == true) goto L36;
        r(r12);
        goto L9
    L36:
        r9 = q(r12);
        goto L9
    L33:
        r8 = q(r12);
        goto L9
    L30:
        r7 = q(r12);
        goto L9
    L27:
        r6 = q(r12);
        goto L9
    L24:
        r5 = q(r12);
        goto L9
    L21:
        r3 = q(r12);
        goto L9
    L14:
        if (r4 != 3) goto L9;
        if (r12.getDepth() != r2) goto L9;
    L38:
        if (r3 != null) goto L40;
        Integer r14 = null;
    L41:
        b<Integer> r15 = a(r14, r5, r6, r7, r8, r9);
        if (r15 != null) goto L45;
        return null;
    L45:
        return a(r15);
    L40:
        r14 = r3;
        goto L41
    L46:
        f13992a.r(r12);
        return r0;
    }

    private final ColorStateList p(XmlPullParser r13) {
        XmlPullParser r14 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.memorydata.plugin");
        b<Integer> r15 = a(a(a(this, r14, MaterialState.NORMAL, null, null, 12, null)), a(a(this, r14, MaterialState.PRESS, null, null, 12, null)), a(a(this, r14, MaterialState.HOVER, null, null, 12, null)), a(a(this, r14, MaterialState.CHECKED, null, null, 12, null)), a(a(this, r14, MaterialState.SELECTED, null, null, 12, null)), a(a(this, r14, MaterialState.DISABLE, null, null, 12, null)));
        if (r15 != null) goto L6;
        return null;
    L6:
        return a(r15);
    }

    private final Integer q(XmlPullParser r3) {
        XmlPullParser r4 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        Integer r0 = a(a(r4, new String[]{TypedValues.Custom.S_COLOR}));
        if (r0 == null) goto L5;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue();
        f13992a.r(r4);
        return Integer.valueOf(r2);
    L5:
        return a(s(r4));
    }

    private final void r(XmlPullParser r4) {
        XmlPullParser r3 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin");
        int r0 = 1;
    L3:
        if (r0 <= 0) goto L13;
        int r1 = r3.next();
        if (r1 == 1) goto L23;
        if (r1 != 2) goto L9;
        r0 = r0 + 1;
        goto L3
    L9:
        if (r1 != 3) goto L3;
        r0 = r0 - 1;
        goto L3
    L23:
        return;
    }

    private final String s(XmlPullParser r7) {
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        int r2 = r8.getDepth();
    L3:
        int r3 = r8.next();
        boolean r4 = true;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L8;
        r(r8);
        goto L3
    L8:
        if (r3 != 3) goto L10;
        if (r8.getDepth() != r2) goto L3;
    L10:
        if (r3 == 4) goto L14;
        if (r3 != 5) goto L3;
    L14:
        r0.append(r8.getText());
    L19:
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "builder.toString()");
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L23;
        r4 = false;
    L23:
        if (r4 == true) goto L40;
        return null;
    L40:
        return r9;
    }
}
