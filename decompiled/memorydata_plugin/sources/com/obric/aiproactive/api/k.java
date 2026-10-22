package com.obric.aiproactive.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0002H\u0002\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0004*\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0002\u001a\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001d\u001a\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010 \"\u000e\u0010!\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"parseAiProactiveArtifacts", "", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "raw", "", "serializeAiProactiveArtifacts", "artifacts", "parseArtifact", "element", "Lcom/google/gson/JsonElement;", "parseResource", "Lcom/obric/aiproactive/api/AiProactiveArtifactResource;", "parsePreview", "Lcom/obric/aiproactive/api/AiProactiveArtifactPreview;", "isSafeDisplayName", "", EventBody.KEY_VALUE, "isSafeLocator", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/aiproactive/api/AiProactiveArtifactResourceKind;", "locator", "isSafeUri", "expectedScheme", "toJsonObject", "Lcom/google/gson/JsonObject;", TypedValues.Custom.S_STRING, ActivityLifecycle.NAME, "nonNegativeLong", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "positiveInt", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "MAX_ARTIFACT_JSON_CHARS", "MAX_ARTIFACTS_PER_RECOMMENDATION", "MAX_DISPLAY_NAME_CHARS", "MAX_LOCATOR_CHARS", "MAX_ERROR_CODE_CHARS", "MAX_ARTIFACT_SIZE_BYTES", "MAX_ARTIFACT_DURATION_MS", "MAX_PREVIEW_DIMENSION", "ARTIFACT_ID_PATTERN", "Lkotlin/text/Regex;", "MIME_TYPE_PATTERN", "ERROR_CODE_PATTERN", "OBJECT_KEY_PATTERN", "ai_proactive_api_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Regex f6257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f6258b = null;
    private static final Regex c = null;
    private static final Regex d = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6259a = null;

        static {
            int[] r0 = new int[AiProactiveArtifactResourceKind.values().length];
            r0[AiProactiveArtifactResourceKind.EXPORTED_FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AiProactiveArtifactResourceKind.CONTENT_URI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AiProactiveArtifactResourceKind.HTTPS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AiProactiveArtifactResourceKind.OBJECT_KEY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f6259a = r0;
        }
    }

    static {
        f6257a = new Regex("[A-Za-z0-9._:-]{1,128}");
        f6258b = new Regex("[A-Za-z0-9!#$&^_.+-]+/[A-Za-z0-9!#$&^_.+-]+");
        c = new Regex("[A-Za-z0-9._:-]+");
        d = new Regex("[A-Za-z0-9._:/-]+");
    }

    private static final j a(JsonElement r17) {
        if (r17.isJsonObject() == true) goto L5;
        return null;
    L5:
        JsonObject r0 = r17.getAsJsonObject();
        Intrinsics.checkNotNull(r0);
        String r2 = a(r0, "artifact_id");
        if (r2 != null) goto L8;
    L83:
        return null;
    L8:
        if (f6257a.matches((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        String r6 = r2;
    L11:
        if (r6 == null) goto L83;
        String r3 = a(r0, "artifact_type");
        if (r3 == null) goto L83;
        AiProactiveArtifactType r7 = AiProactiveArtifactType.Companion.a(r3);
        if (r7 == null) goto L83;
        String r4 = a(r0, "state");
        if (r4 == null) goto L83;
        AiProactiveArtifactState r8 = AiProactiveArtifactState.Companion.a(r4);
        if (r8 == null) goto L83;
        String r5 = a(r0, Api.KEY_DISPLAY_NAME);
        if (r5 == null) goto L83;
        if (b(r5) == false) goto L25;
        String r9 = r5;
    L26:
        if (r9 == null) goto L83;
        String r10 = a(r0, "mime_type");
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        String r11 = r10;
        boolean r12 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == true) goto L36;
    L38:
        JsonElement r14 = r0.get("resource");
        if (r14 == null) goto L41;
        m r15 = b(r14);
    L43:
        if (r8 != AiProactiveArtifactState.READY) goto L48;
        if (r15 != null) goto L46;
    L47:
        return null;
    L46:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L47;
    L48:
        Long r16 = b(r0, "size_bytes");
        if (r16 != null) goto L51;
    L56:
        Long r18 = null;
    L57:
        Long r19 = b(r0, "duration_ms");
        if (r19 != null) goto L60;
    L65:
        Long r110 = null;
    L66:
        JsonElement r20 = r0.get("preview");
        if (r20 == null) goto L69;
        l r111 = c(r20);
    L70:
        String r1 = a(r0, "error_code");
        if (r1 != null) goto L73;
    L80:
        String r112 = null;
    L82:
        return new j(r6, r7, r8, r9, r11, r15, r18, r110, r111, r112);
    L73:
        if (r1.length() <= 64) goto L75;
    L77:
        r12 = false;
    L78:
        if (r12 == false) goto L80;
        r112 = r1;
        goto L82
    L75:
        if (c.matches((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L77;
    L69:
        r111 = null;
        goto L70
    L60:
        if (((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).longValue() > WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L62;
        boolean r113 = true;
    L63:
        if (r113 == false) goto L65;
        r110 = r19;
        goto L66
    L62:
        r113 = false;
        goto L63
    L51:
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue() > 2147483648L) goto L53;
        boolean r114 = true;
    L54:
        if (r114 == false) goto L56;
        r18 = r16;
        goto L57
    L53:
        r114 = false;
        goto L54
    L41:
        r15 = null;
        goto L43
    L36:
        if (f6258b.matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L38;
        return null;
    L33:
        r13 = false;
        goto L34
    L25:
        r9 = null;
        goto L26
    L10:
        r6 = null;
        goto L11
    }

    private static final String a(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonPrimitive() == true) goto L8;
    L12:
        return null;
    L8:
        if (r3.getAsJsonPrimitive().isString() == false) goto L12;
        String r4 = r3.getAsString();
        Intrinsics.checkNotNullExpressionValue(r4, "getAsString(...)");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final List<j> a(String r6) {
        if (r6 == null) goto L5;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L35;
        if (r7.length() > 262144) goto L35;
        JsonElement r8 = JsonParser.parseString(r7);     // Catch: IllegalStateException -> L30 JsonParseException -> L32
    L15:
        if (r8.isJsonArray() == false) goto L17;
        HashSet r1 = new HashSet();
        ArrayList r2 = new ArrayList(20);
        Iterator<JsonElement> r9 = r8.getAsJsonArray().iterator();
        Intrinsics.checkNotNullExpressionValue(r9, "iterator(...)");
    L20:
        if (r9.hasNext() == false) goto L29;
        JsonElement r4 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r4);
        j r5 = a(r4);
        if (r5 == null) goto L20;
        if (r1.add(r5.a()) == false) goto L20;
        ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).add(r5);
        if (r2.size() != 20) goto L20;
    L29:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L17:
        return CollectionsKt.emptyList();
    L33:
        return CollectionsKt.emptyList();
    L31:
        return CollectionsKt.emptyList();
    L35:
        return CollectionsKt.emptyList();
    L5:
        r7 = null;
        goto L6
    }

    private static final boolean a(AiProactiveArtifactResourceKind r12, String r13) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L80;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L6:
        if (r3 >= r0.length()) goto L19;
        char r4 = r0.charAt(r3);
        if (r4 != 0) goto L10;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == true) goto L17;
        r3 = r3 + 1;
        goto L6
    L17:
        boolean r1 = true;
    L20:
        if (r1 == true) goto L100;
        int r14 = a.f6259a[r12.ordinal()];
        if (r14 == 1) goto L56;
        if (r14 != 2) goto L26;
        String r15 = Params.CONTENT;
    L96:
        return a(r13, r15);
    L26:
        if (r14 != 3) goto L28;
        r15 = LocationInfoConst.HTTPS;
        goto L96
    L28:
        if (r14 != 4) goto L51;
        if (d.matches((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L93;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L34;
    L36:
        Iterator r17 = r16.iterator();
    L38:
        if (r17.hasNext() == false) goto L35;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r18, ".") == false) goto L42;
    L45:
        boolean r19 = true;
    L46:
        if (r19 == false) goto L38;
        boolean r110 = false;
    L48:
        if (r110 == true) goto L95;
        return false;
    L95:
        return true;
    L42:
        if (Intrinsics.areEqual(r18, "..") == true) goto L45;
        r19 = false;
    L35:
        r110 = true;
        goto L48
    L34:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L36;
    L93:
        return false;
    L51:
        throw new NoWhenBranchMatchedException();
    L56:
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), '/', false, 2, null) == false) goto L58;
        return false;
    L58:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), '\\', false, 2, null) == true) goto L98;
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r111, Collection.class) == true) goto L62;
    L64:
        Iterator r112 = r111.iterator();
    L66:
        if (r112.hasNext() == false) goto L63;
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r113, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L70;
    L75:
        boolean r114 = true;
    L76:
        if (r114 == false) goto L66;
        boolean r115 = false;
    L78:
        if (r115 == true) goto L95;
        return false;
    L70:
        if (Intrinsics.areEqual(r113, ".") == true) goto L75;
        if (Intrinsics.areEqual(r113, "..") == true) goto L75;
        r114 = false;
    L63:
        r115 = true;
        goto L78
    L62:
        if (((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L64;
    L98:
        return false;
    L100:
        return false;
    L10:
        if (r4 == '\n') goto L15;
        if (r4 == '\r') goto L15;
        r5 = false;
        goto L16
    L19:
        r1 = false;
        goto L20
    L80:
        return false;
    }

    private static final boolean a(String r4, String r5) {
        URI r1 = new URI(r4);     // Catch: URISyntaxException -> L18
        if (StringsKt.equals(r1.getScheme(), r5, true) == false) goto L21;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.getHost(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        return false;
    L15:
        if (r1.getUserInfo() == null) goto L17;
        return false;
    L17:
        return true;
    L9:
        if (StringsKt.isBlank(r6) == true) goto L12;
        r7 = false;
        goto L13
    L21:
        return false;
    L24:
        return false;
    }

    private static final m b(JsonElement r5) {
        if (r5.isJsonObject() == true) goto L5;
        return null;
    L5:
        JsonObject r6 = r5.getAsJsonObject();
        Intrinsics.checkNotNull(r6);
        String r0 = a(r6, MemoryInfoSectionEditActivity.EXTRA_KIND);
        if (r0 == null) goto L23;
        AiProactiveArtifactResourceKind r1 = AiProactiveArtifactResourceKind.Companion.a(r0);
        if (r1 == null) goto L24;
        String r2 = a(r6, "locator");
        if (r2 != null) goto L12;
        return null;
    L12:
        if (r2.length() <= 2048) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L20;
        r2 = null;
    L20:
        if (r2 != null) goto L22;
        return null;
    L22:
        return new m(r1, r2, b(r6, "expires_at_ms"));
    L14:
        if (a(r1, r2) == false) goto L16;
        r3 = true;
        goto L17
    L24:
        return null;
    L23:
        return null;
    }

    private static final Long b(JsonObject r4, String r5) {
        JsonElement r6 = r4.get(r5);
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.isJsonPrimitive() == true) goto L8;
        return null;
    L8:
        if (r6.getAsJsonPrimitive().isNumber() == false) goto L19;
        Long r7 = Long.valueOf(r6.getAsLong());
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == true) goto L16;
        return null;
    L16:
        return r7;
    L13:
        r0 = false;
        goto L14
    L19:
        return null;
    }

    private static final boolean b(String r7) {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L28;
        if (r7.length() > 240) goto L28;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '/', false, 2, null) == true) goto L28;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\\', false, 2, null) == true) goto L28;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L12:
        if (r0 >= r8.length()) goto L24;
        char r1 = r8.charAt(r0);
        if (r1 != '\n') goto L16;
    L20:
        boolean r2 = true;
    L21:
        if (r2 == true) goto L22;
        r0 = r0 + 1;
        goto L12
    L22:
        boolean r9 = false;
    L25:
        if (r9 == false) goto L28;
        return true;
    L16:
        if (r1 == '\r') goto L20;
        if (r1 == 0) goto L20;
        r2 = false;
        goto L21
    L24:
        r9 = true;
    L28:
        return false;
    }

    private static final l c(JsonElement r11) {
        if (r11.isJsonObject() == true) goto L5;
        return null;
    L5:
        JsonObject r12 = r11.getAsJsonObject();
        Intrinsics.checkNotNull(r12);
        String r0 = a(r12, "state");
        if (r0 == null) goto L34;
        boolean r3 = false;
        if (Intrinsics.areEqual(r0, "ready") == false) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
        String r6 = r0;
    L17:
        if (r6 == null) goto L34;
        String r1 = a(r12, "thumbnail_locator");
        if (r1 != null) goto L21;
    L25:
        String r7 = null;
    L26:
        String r4 = a(r12, "mime_type");
        if (r4 != null) goto L29;
    L31:
        String r8 = null;
    L33:
        return new l(r6, r7, r8, c(r12, "width"), c(r12, "height"));
    L29:
        if (f6258b.matches((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L31;
        r8 = r4;
        goto L33
    L21:
        if (r1.length() > 2048) goto L23;
        r3 = true;
    L23:
        if (r3 == false) goto L25;
        r7 = r1;
        goto L26
    L16:
        r6 = null;
        goto L17
    L10:
        if (Intrinsics.areEqual(r0, "unavailable") == true) goto L13;
        r2 = false;
    L34:
        return null;
    }

    private static final Integer c(JsonObject r6, String r7) {
        Long r8 = b(r6, r7);
        if (r8 == null) goto L15;
        Long r9 = Long.valueOf(r8.longValue());
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue();
        boolean r3 = false;
        if (1 <= r0) goto L7;
    L9:
        if (r3 == true) goto L12;
        r9 = null;
    L12:
        if (r9 != null) goto L14;
        return null;
    L14:
        return Integer.valueOf((int) r9.longValue());
    L7:
        if (r0 >= 16385) goto L9;
        r3 = true;
        goto L9
    L15:
        return null;
    }
}
