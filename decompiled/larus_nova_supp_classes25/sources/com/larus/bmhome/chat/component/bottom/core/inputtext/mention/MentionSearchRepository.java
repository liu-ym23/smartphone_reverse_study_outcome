package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.net.Uri;
import androidx.core.text.HtmlCompat;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import com.larus.network.http.HttpExtKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MentionSearchRepository {
    public static final MentionSearchRepository a = null;
    public static final Gson b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MentionSearchResultType.values().length];
            r0[MentionSearchResultType.DRIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[MentionSearchResultType.CONTACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[MentionSearchResultType.CONVERSATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MentionSearchResultType.GROUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[MentionSearchResultType.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public MentionSearchRepository() {
    }

    static {
        a = new MentionSearchRepository();
        b = new Gson();
    }

    public static List a(String r9) {
        if (r9 != null) goto L4;
        r9 = "";
    L4:
        ArrayList r6 = new ArrayList();
        int r2 = 0;
    L6:
        if (r2 >= r9.length()) goto L25;
        int r0 = StringsKt.indexOf$default(r9, "<h>", r2, false, 4, null);
        if (r0 < 0) goto L25;
        int r8 = r0 + 3;
        int r1 = StringsKt.indexOf$default(r9, "</h>", r8, false, 4, null);
        if (r1 < 0) goto L25;
        String r3 = c(r9.substring(r8, r1));
        boolean r4 = true;
        if ((!StringsKt.isBlank(r3)) == false) goto L24;
        if (r6.isEmpty() == true) goto L22;
        Iterator r5 = r6.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        if (StringsKt.equals((String) r5.next(), r3, true) == false) goto L18;
        r4 = false;
    L22:
        if (r4 == false) goto L24;
        r6.add(r3);
    L24:
        r2 = r1 + 4;
    L25:
        return r6;
    }

    public static boolean b(String r3) {
        if (StringsKt.startsWith(r3, "https://", true) != true) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (StringsKt.startsWith(r3, "http://", true) != true) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        r4 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public static String c(String r1) {
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        return StringsKt.trim(HtmlCompat.fromHtml(r1, 0).toString()).toString();
    }

    public static MentionSearchResultType i(t0 r6) {
        MentionSearchResultType.a r0 = MentionSearchResultType.Companion;
        int r1 = r6.b();
        r0.getClass();
        MentionSearchResultType r2 = MentionSearchResultType.a.a(r1);
        int r3 = 0;
        if (r2 != MentionSearchResultType.UNKNOWN) goto L5;
        boolean r4 = true;
    L6:
        MentionSearchResultType r5 = null;
        if (r4 == false) goto L10;
        r2 = null;
    L10:
        if (r2 != null) goto L27;
        String r7 = r6.a();
        MentionSearchResultType[] r8 = MentionSearchResultType.values();
        int r9 = r8.length;
    L12:
        if (r3 >= r9) goto L21;
        MentionSearchResultType r10 = r8[r3];
        MentionSearchDomain r11 = r10.getDomain();
        if (r11 == null) goto L16;
        String r12 = r11.getKey();
    L18:
        if (Intrinsics.areEqual(r12, r7) == true) goto L19;
        r3 = r3 + 1;
        goto L12
    L19:
        r5 = r10;
        goto L21
    L16:
        r12 = null;
    L21:
        if (r5 != null) goto L24;
        return MentionSearchResultType.UNKNOWN;
    L24:
        return r5;
    L27:
        return r2;
    L5:
        r4 = false;
        goto L6
    }

    public final Object d(String r7, Continuation<? super f0> r8) {
        if ((r8 instanceof MentionSearchRepository$queryContacts$1) == false) goto L7;
        MentionSearchRepository$queryContacts$1 r0 = (MentionSearchRepository$queryContacts$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        f0 r10 = (f0) r9;
        if (r10 == null) goto L20;
        return r10;
    L20:
        return new f0(null, null, null, null, 31);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        List<? extends MentionSearchDomain> r11 = CollectionsKt.listOf(MentionSearchDomain.CONTACT);
        r0.label = 1;
        r9 = e(r7, r11, MapsKt.emptyMap(), r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new MentionSearchRepository$queryContacts$1(this, r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v41, types: [java.util.ArrayList] */
    public final Object h(boolean r29, Continuation<? super f0> r30) {
        if ((r30 instanceof MentionSearchRepository$recommend$1) == false) goto L7;
        MentionSearchRepository$recommend$1 r2 = (MentionSearchRepository$recommend$1) r30;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MentionSearchRepository$recommend$1 r14 = r2;
        Object r1 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        boolean r0 = r14.Z$0;
        ResultKt.throwOnFailure(r1);
        Object r6 = r1;
        boolean r7 = r0;
        boolean r8 = true;
    L21:
        v0 r9 = (v0) ((com.larus.network.http.a) r6).b;
        if (r9 == null) goto L24;
        List<y0> r10 = r9.a();
        if (r10 == null) goto L74;
        List r11 = CollectionsKt.filterNotNull(r10);
        if (r11 == null) goto L74;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L31:
        if (r13.hasNext() == false) goto L40;
        Object r15 = r13.next();
        y0 r16 = (y0) r15;
        if (r7 == true) goto L35;
    L37:
        boolean r17 = false;
    L38:
        if (r17 == false) goto L31;
        r12.add(r15);
        goto L31
    L35:
        if (r16.b() != MentionSearchResultType.GROUP.getProtocolValue()) goto L37;
        r17 = true;
        goto L38
    L40:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r12.iterator();
    L42:
        if (r19.hasNext() == false) goto L47;
        List<x0> r20 = ((y0) r19.next()).a();
        if (r20 != null) goto L46;
        r20 = CollectionsKt.emptyList();
    L46:
        CollectionsKt.addAll(r18, CollectionsKt.filterNotNull(r20));
        goto L42
    L47:
        ArrayList r21 = new ArrayList();
        Iterator r22 = r18.iterator();
    L49:
        if (r22.hasNext() == false) goto L68;
        x0 r23 = (x0) r22.next();
        Regex r24 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.a;
        w0 r25 = r23.a();
        if (r25 == null) goto L53;
        String r26 = r25.e();
    L54:
        String r27 = c(r23.c());
        w0 r110 = r23.a();
        if (r110 == null) goto L57;
        String r111 = r110.a();
    L58:
        w0 r28 = r23.a();
        if (r28 == null) goto L61;
        String r31 = r28.b();
    L62:
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r32 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.e(r26, r27, r111, r31);
        if (r32 == null) goto L65;
        c1 r33 = new c1(r32, null, null, 6);
    L66:
        if (r33 == null) goto L49;
        r21.add(r33);
        goto L49
    L65:
        r33 = null;
        goto L66
    L61:
        r31 = null;
        goto L62
    L57:
        r111 = null;
        goto L58
    L53:
        r26 = null;
        goto L54
    L68:
        HashSet r34 = new HashSet();
        ?? r35 = new ArrayList();
        Iterator r36 = r21.iterator();
    L70:
        if (r36.hasNext() == false) goto L75;
        Object r37 = r36.next();
        if (r34.add(((c1) r37).a.a) == false) goto L70;
        r35.add(r37);
    L75:
        if (r35 != 0) goto L77;
        r35 = CollectionsKt.emptyList();
    L77:
        ?? r112 = r35;
        List<y0> r38 = r9.a();
        if (r38 == null) goto L170;
        List r39 = CollectionsKt.filterNotNull(r38);
        if (r39 == null) goto L170;
        ArrayList r40 = new ArrayList();
        Iterator r41 = r39.iterator();
    L83:
        if (r41.hasNext() == false) goto L90;
        Object r42 = r41.next();
        if (((y0) r42).b() != MentionSearchResultType.DRIVE.getProtocolValue()) goto L87;
        boolean r43 = true;
    L88:
        if (r43 == false) goto L83;
        r40.add(r42);
        goto L83
    L87:
        r43 = false;
        goto L88
    L90:
        ArrayList r44 = new ArrayList();
        Iterator r45 = r40.iterator();
    L92:
        if (r45.hasNext() == false) goto L97;
        List<x0> r46 = ((y0) r45.next()).a();
        if (r46 != null) goto L96;
        r46 = CollectionsKt.emptyList();
    L96:
        CollectionsKt.addAll(r44, CollectionsKt.filterNotNull(r46));
        goto L92
    L97:
        ArrayList r47 = new ArrayList();
        Iterator r48 = r44.iterator();
    L99:
        if (r48.hasNext() == false) goto L163;
        x0 r49 = (x0) r48.next();
        String r50 = r49.b();
        if (r50 != null) goto L103;
    L105:
        boolean r51 = false;
    L106:
        if (r51 == false) goto L108;
        String r210 = r50;
    L109:
        if (r210 == null) goto L124;
        String r52 = r49.c();
        if (r52 == null) goto L114;
        String r53 = c(r52);
    L115:
        if (r53 != null) goto L117;
    L119:
        boolean r54 = false;
    L120:
        if (r54 == false) goto L122;
        String r113 = r53;
    L123:
        if (r113 == null) goto L124;
        InputReferenceType r114 = InputReferenceType.DRIVE;
        w0 r55 = r49.a();
        if (r55 == null) goto L132;
        String r56 = r55.c();
        if (r56 == null) goto L132;
        if (b(r56) == false) goto L132;
        String r211 = r56;
    L133:
        w0 r57 = r49.a();
        if (r57 == null) goto L140;
        String r58 = r57.d();
        if (r58 == null) goto L140;
        Integer r59 = StringsKt.toIntOrNull(r58);
        if (r59 == null) goto L140;
        int r60 = r59.intValue();
    L141:
        String r115 = r49.b();
        if (r115 != null) goto L144;
        r115 = "";
    L144:
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r61 = new com.larus.bmhome.chat.component.bottom.core.inputtext.d0(r210, r113, r114, r210, r211, new com.larus.bmhome.chat.component.bottom.core.inputtext.i0(r60, r115, 5), null, null, null, null, 960);
    L145:
        if (r61 == null) goto L160;
        w0 r62 = r49.a();
        if (r62 == null) goto L158;
        String r63 = r62.f();
        if (r63 == null) goto L158;
        Long r64 = StringsKt.toLongOrNull(r63);
        if (r64 == null) goto L158;
        if (r64.longValue() <= 0) goto L155;
        boolean r116 = true;
    L156:
        if (r116 == false) goto L158;
    L159:
        c1 r65 = new c1(r61, null, r64, 2);
    L161:
        if (r65 == null) goto L99;
        r47.add(r65);
        goto L99
    L155:
        r116 = false;
    L158:
        r64 = null;
        goto L159
    L160:
        r65 = null;
    L140:
        r60 = 0;
    L132:
        r211 = null;
        goto L133
    L122:
        r113 = null;
        goto L123
    L117:
        if ((StringsKt.isBlank(r53) ^ r8) != r8) goto L119;
        r54 = true;
        goto L120
    L114:
        r53 = null;
    L124:
        r61 = null;
        goto L145
    L108:
        r210 = null;
        goto L109
    L103:
        if (b(r50) != r8) goto L105;
        r51 = true;
        goto L106
    L163:
        HashSet r66 = new HashSet();
        ArrayList r67 = new ArrayList();
        Iterator r68 = r47.iterator();
    L165:
        if (r68.hasNext() == false) goto L169;
        Object r69 = r68.next();
        if (r66.add(((c1) r69).a.a) == false) goto L165;
        r67.add(r69);
        goto L165
    L169:
        List r70 = r67;
    L171:
        List<y0> r71 = r9.a();
        if (r71 == null) goto L240;
        List r72 = CollectionsKt.filterNotNull(r71);
        if (r72 == null) goto L240;
        ArrayList r73 = new ArrayList();
        Iterator r74 = r72.iterator();
    L177:
        if (r74.hasNext() == false) goto L184;
        Object r75 = r74.next();
        if (((y0) r75).b() != MentionSearchResultType.CONVERSATION.getProtocolValue()) goto L181;
        boolean r76 = true;
    L182:
        if (r76 == false) goto L177;
        r73.add(r75);
        goto L177
    L181:
        r76 = false;
        goto L182
    L184:
        ArrayList r77 = new ArrayList();
        Iterator r78 = r73.iterator();
    L186:
        if (r78.hasNext() == false) goto L191;
        List<x0> r79 = ((y0) r78.next()).a();
        if (r79 != null) goto L190;
        r79 = CollectionsKt.emptyList();
    L190:
        CollectionsKt.addAll(r77, CollectionsKt.filterNotNull(r79));
        goto L186
    L191:
        ArrayList r80 = new ArrayList();
        Iterator r81 = r77.iterator();
    L193:
        if (r81.hasNext() == false) goto L230;
        x0 r82 = (x0) r81.next();
        String r83 = r82.b();
        if (r83 != null) goto L197;
    L199:
        boolean r84 = false;
    L200:
        if (r84 == true) goto L203;
        r83 = null;
    L203:
        if (r83 == null) goto L218;
        String r85 = r82.c();
        if (r85 == null) goto L208;
        String r86 = c(r85);
    L209:
        if (r86 != null) goto L211;
    L213:
        boolean r117 = false;
    L214:
        if (r117 == false) goto L216;
        String r118 = r86;
    L217:
        if (r118 == null) goto L218;
        w0 r87 = r82.a();
        if (r87 == null) goto L226;
        String r88 = r87.c();
        if (r88 == null) goto L226;
        if (b(r88) == false) goto L226;
        String r212 = r88;
    L227:
        InputReferenceType r119 = InputReferenceType.CONVERSATION;
        Regex r89 = com.larus.bmhome.chat.markdown.richtext.n.a;
        Intrinsics.checkNotNullParameter(r83, "conversationId");
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r90 = new com.larus.bmhome.chat.component.bottom.core.inputtext.d0(r83, r118, r119, new Uri.Builder().scheme("conversation").authority(r83).build().toString(), r212, null, null, null, null, null, 992);
    L228:
        if (r90 == null) goto L193;
        r80.add(r90);
    L226:
        r212 = null;
        goto L227
    L216:
        r118 = null;
        goto L217
    L211:
        if ((StringsKt.isBlank(r86) ^ r8) != r8) goto L213;
        r117 = true;
        goto L214
    L208:
        r86 = null;
    L218:
        r90 = null;
        goto L228
    L197:
        if ((StringsKt.isBlank(r83) ^ r8) != r8) goto L199;
        r84 = true;
        goto L200
    L230:
        HashSet r91 = new HashSet();
        ArrayList r92 = new ArrayList();
        Iterator r93 = r80.iterator();
    L232:
        if (r93.hasNext() == false) goto L236;
        Object r94 = r93.next();
        if (r91.add(((com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r94).a) == false) goto L232;
        r92.add(r94);
        goto L232
    L236:
        ?? r95 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r92, 10));
        Iterator r96 = r92.iterator();
    L238:
        if (r96.hasNext() == false) goto L242;
        r95.add(new c1((com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r96.next(), null, null, 6));
    L242:
        return new f0(r70, null, r112, r95, 18);
    L240:
        r95 = CollectionsKt.emptyList();
    L170:
        r70 = CollectionsKt.emptyList();
    L74:
        r35 = 0;
        goto L75
    L24:
        return new f0(null, null, null, null, 31);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        List r97 = CollectionsKt.createListBuilder();
        r97.add(MentionSearchDomain.CONVERSATION.getKey());
        r97.add(MentionSearchDomain.DRIVE.getKey());
        if (r29 == false) goto L17;
        r97.add(MentionSearchDomain.GROUP.getKey());
    L17:
        JSONObject r99 = new JSONObject().put("scene", "mention").put("domain_keys", new JSONArray(CollectionsKt.build(r97))).put("ext", new JSONObject());
        Intrinsics.checkNotNull(r99);
        r14.Z$0 = r29;
        r14.label = 1;
        r8 = true;
        Object r100 = HttpExtKt.k("Message", v0.class, "/alice/search/mention_recommend", r99, null, null, true, null, null, null, r14, 944);
        if (r100 != r4) goto L20;
        return r4;
    L20:
        r6 = r100;
        r7 = r29;
    L7:
        r2 = new MentionSearchRepository$recommend$1(this, r30);
        goto L8
    }

    public final Object g(String r7, List<? extends MentionSearchDomain> r8, Continuation<? super f0> r9) {
        if ((r9 instanceof MentionSearchRepository$queryReferences$1) == false) goto L7;
        MentionSearchRepository$queryReferences$1 r0 = (MentionSearchRepository$queryReferences$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L17:
        f0 r11 = (f0) r10;
        if (r11 == null) goto L20;
        return r11;
    L20:
        return new f0(null, null, null, null, 31);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r0.label = 1;
        r10 = e(r7, r8, MapsKt.emptyMap(), r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new MentionSearchRepository$queryReferences$1(this, r9);
        goto L8
    }

    /* JADX WARN: Failed to calculate best type for var: r0v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v14 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v26 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v27 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v27 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v28 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v28 ??, new type: java.lang.Enum
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v72 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v72 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v87 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v87 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v88 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v88 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v90 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v90 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r10v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v11 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r10v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v8 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r10v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v9 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r14v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v2 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v5 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v6 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v5 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.t0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v11 ??, new type: java.lang.Object
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public final java.lang.Object e(java.lang.String r33, java.util.List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain> r34, java.util.Map<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain, java.lang.String> r35, kotlin.coroutines.Continuation<? super com.larus.bmhome.chat.component.bottom.core.inputtext.mention.f0> r36) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0150: CHECK_CAST (r9v5 ?? I:com.larus.bmhome.chat.component.bottom.core.inputtext.mention.t0) = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.t0) (r0v13 java.lang.Object) in method: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchRepository.e(java.lang.String, java.util.List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain>, java.util.Map<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain, java.lang.String>, kotlin.coroutines.Continuation<? super com.larus.bmhome.chat.component.bottom.core.inputtext.mention.f0>):java.lang.Object, file: /private/tmp/nixiang/classes25.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchRepository.e(java.lang.String, java.util.List, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object f(String r5, MentionSearchDomain r6, String r7, Continuation<? super f0> r8) {
        if ((r8 instanceof MentionSearchRepository$queryMore$1) == false) goto L7;
        MentionSearchRepository$queryMore$1 r0 = (MentionSearchRepository$queryMore$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (MentionSearchDomain) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L17:
        f0 r10 = (f0) r9;
        if (r10 == null) goto L23;
        if (r10.e.containsKey(r6) == false) goto L23;
        return r10;
    L23:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        List<? extends MentionSearchDomain> r11 = CollectionsKt.listOf(r6);
        Map<MentionSearchDomain, String> r12 = MapsKt.mapOf(TuplesKt.to(r6, r7));
        r0.L$0 = r6;
        r0.label = 1;
        r9 = e(r5, r11, r12, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new MentionSearchRepository$queryMore$1(this, r8);
        goto L8
    }
}
