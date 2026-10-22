package com.obric.dejavu.library.cipher;

import android.content.Context;
import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.dejavu.library.DbKvResult;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbStatus;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 G2\u00020\u0001:\u0003GHIB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\u0012\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\u001f0\u001ej\u0002` H\u0016J(\u0010!\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\"0\u001ej\u0002`#2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J*\u0010'\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0018H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016JM\u0010-\u001a$\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020/0.0\"0\"0\u001ej\u0002`02\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140\"2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016¢\u0006\u0002\u00106J \u0010-\u001a\u0002072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0018H\u0016J\u0010\u0010:\u001a\u0002072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010;\u001a\u00020\u0012H\u0016J\u0018\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u000eH\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010\u00142\u0006\u0010B\u001a\u00020CH\u0002J\u001a\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherInstanceImpl;", "Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "dbInstance", "Lcom/obric/dejavu/library/DbInstance;", "cryptoOpt", "Lcom/obric/dejavu/library/cipher/CryptoOptions;", "encryptor", "LadcpeJava/adcpe/Encryptor;", "decryptor", "LadcpeJava/adcpe/Decryptor;", "(Lcom/obric/dejavu/library/DbInstance;Lcom/obric/dejavu/library/cipher/CryptoOptions;LadcpeJava/adcpe/Encryptor;LadcpeJava/adcpe/Decryptor;)V", "gson", "Lcom/google/gson/Gson;", "clear", "Lcom/obric/dejavu/library/DbStatus;", IslandSession.REOPEN_VALUE_CLOSE, "", "dims", "", "doubleArray2FloatArray", "", "doubleArray", "", "exists", "", "key", "", "floatArray2DoubleArray", "floatArray", "getDbInfo", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInfo;", "Lcom/obric/dejavu/library/DbInfoResult;", "getKeys", "", "Lcom/obric/dejavu/library/DbKeysResult;", CommonConsts.APM_INNER_EVENT_COST_START, "end", "getProperty", "insert", "vec", EventBody.KEY_VALUE, "normalize", ActivityLifecycle.NAME, "remove", "search", "Lkotlin/Pair;", "", "Lcom/obric/dejavu/library/DbVecResult;", "vecs", "k", "", "opt", "Lcom/obric/dejavu/library/DbSearchOption;", "([[FILcom/obric/dejavu/library/DbSearchOption;)Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbKvResult;", "getValue", "getVec", "searchAndDecrypt", "size", "updateIndexConfig", "cfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "rebuildNow", "validate", "vecDecrypt", "ciphertext", "LadcpeJava/adcpe/Ciphertext;", "vecEncrypt", "plainVec", "isFixed", "Companion", "DbCipherExtraInfoDeserializer", "DbCipherExtraInfoFields", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbCipherInstanceImpl extends d {
    public static final a c = null;
    private final com.obric.dejavu.library.c d;
    private com.obric.dejavu.library.cipher.a e;
    private adcpeJava.adcpe.c f;
    private adcpeJava.adcpe.b g;
    private final Gson h;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0006H\u0002J\u0016\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\f\u0010\u0010\u001a\u00020\u0011*\u00020\fH\u0002¨\u0006\u0013"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherInstanceImpl$DbCipherExtraInfoDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/dejavu/library/cipher/DbCipherExtraInfo;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "asNullableString", "", "getNullableString", "Lcom/google/gson/JsonObject;", "key", "isNAndNormHexValue", "", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class DbCipherExtraInfoDeserializer implements JsonDeserializer<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f7877a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        private static final Regex f7878b = null;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherInstanceImpl$DbCipherExtraInfoDeserializer$Companion;", "", "()V", "HEX_REGEX", "Lkotlin/text/Regex;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        private static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            f7877a = new a(null);
            f7878b = new Regex("^[0-9a-fA-F]{80}$");
        }

        public DbCipherExtraInfoDeserializer() {
        }

        private final String a(JsonElement r3) {
            if (r3.isJsonNull() == false) goto L9;
            return null;
        L9:
            return r3.getAsString();
        L8:
            return (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        }

        private final String a(JsonObject r1, String r2) {
            JsonElement r3 = r1.get(r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return a(r3);
        }

        private final boolean a(String r3) {
            return f7878b.matches((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        public c a(JsonElement r6, Type r7, JsonDeserializationContext r8) {
            Type r9 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.memorydata.plugin");
            JsonDeserializationContext r10 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r8, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
            String r11 = null;
            if (r6 != null) goto L5;
        L10:
            JsonObject r12 = null;
        L11:
            if (r12 != null) goto L15;
            return new c(null, null, 3, null);
        L15:
            if (r12.has(EventBody.KEY_VALUE) == true) goto L47;
            if (r12.has("nAndNormHex") == true) goto L47;
            Set<Map.Entry<String, JsonElement>> r13 = r12.entrySet();
            Intrinsics.checkNotNullExpressionValue(r13, "jsonObject.entrySet()");
            List r14 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"));
            Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            String r0 = null;
            String r2 = null;
        L21:
            if (r15.hasNext() == false) goto L30;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r3, "(_, element)");
            JsonElement r4 = (JsonElement) ZeusTransformUtils.preCheckCast(r3.getValue(), JsonElement.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r4, "element");
            String r5 = a(r4);
            if (r5 == null) goto L21;
            if (a(r5) == true) goto L27;
            if (r0 != null) goto L21;
            r0 = r5;
            goto L21
        L27:
            r2 = r5;
            goto L21
        L30:
            if (r0 != null) goto L45;
            if (r2 != null) goto L45;
            Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r14, 0), Map.Entry.class, "com.obric.memorydata.plugin");
            if (r16 == null) goto L37;
            JsonElement r17 = (JsonElement) ZeusTransformUtils.preCheckCast(r16.getValue(), JsonElement.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L37;
            r0 = a(r17);
        L38:
            Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r14, 1), Map.Entry.class, "com.obric.memorydata.plugin");
            if (r18 == null) goto L43;
            JsonElement r19 = (JsonElement) ZeusTransformUtils.preCheckCast(r18.getValue(), JsonElement.class, "com.obric.memorydata.plugin");
            if (r19 == null) goto L43;
            r11 = a(r19);
        L43:
            r2 = r11;
        L37:
            r0 = null;
        L45:
            return new c(r0, r2);
        L47:
            return new c(a(r12, EventBody.KEY_VALUE), a(r12, "nAndNormHex"));
        L5:
            if (r6.isJsonObject() == true) goto L8;
            r6 = null;
        L8:
            if (r6 == null) goto L10;
            r12 = r6.getAsJsonObject();
            goto L11
        }

        @Override // com.google.gson.JsonDeserializer
        public /* synthetic */ c deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
            return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ0\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherInstanceImpl$Companion;", "", "()V", "TAG", "", "openDb", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "Lcom/obric/dejavu/library/cipher/DbCipherOpenResult;", "context", "Landroid/content/Context;", "dirPrefix", "opt", "Lcom/obric/dejavu/library/DbOptions;", "cryptoOpt", "Lcom/obric/dejavu/library/cipher/CryptoOptions;", "dbName", "removeDb", "Lcom/obric/dejavu/library/DbStatus;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final DbObjResult<d> a(Context r6, String r7, com.obric.dejavu.library.d r8, com.obric.dejavu.library.cipher.a r9) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r7, "dirPrefix");
            Intrinsics.checkNotNullParameter(r8, "opt");
            Intrinsics.checkNotNullParameter(r9, "cryptoOpt");
            DbStatus r5 = e.f7886a.a(r9);
            if (Intrinsics.areEqual(r5, DbStatus.f7870a.a()) == true) goto L6;
            Log.e("DbCipherInstanceImpl", "code: " + r5.a() + ", msg: " + r5.b());
            return new DbObjResult(r5, null);
        L6:
            DbObjResult<com.obric.dejavu.library.c> r10 = com.obric.dejavu.library.jni.a.f7891b.a(r7, r8);
            if (Intrinsics.areEqual(r10.a(), DbStatus.f7870a.a()) == true) goto L11;
            Log.e("DbCipherInstanceImpl", "code: " + r10.a().a() + ", msg: " + r10.a().b());
            return new DbObjResult(r10.a(), null);
        L11:
            if (r10.b() == null) goto L13;
            adcpeJava.adcpe.d r11 = adcpeJava.adcpe.d.a(r9.b(), (int) ((com.obric.dejavu.library.c) ZeusTransformUtils.preCheckCast(r10.b(), com.obric.dejavu.library.c.class, "com.obric.memorydata.plugin")).c(), r9.c());
            Intrinsics.checkNotNullExpressionValue(r11, "fromSeed(cryptoOpt.seed,…(), cryptoOpt.algVersion)");
            adcpeJava.adcpe.d r12 = adcpeJava.adcpe.d.a(r9.b(), (int) ((com.obric.dejavu.library.c) ZeusTransformUtils.preCheckCast(r10.b(), com.obric.dejavu.library.c.class, "com.obric.memorydata.plugin")).c(), r9.c());
            Intrinsics.checkNotNullExpressionValue(r12, "fromSeed(cryptoOpt.seed,…(), cryptoOpt.algVersion)");
            adcpeJava.adcpe.c r13 = new adcpeJava.adcpe.c(r11, r9.a());
            adcpeJava.adcpe.b r14 = new adcpeJava.adcpe.b(r12, r9.a());
            return new DbObjResult(r10.a(), new DbCipherInstanceImpl((com.obric.dejavu.library.c) ZeusTransformUtils.preCheckCast(r10.b(), com.obric.dejavu.library.c.class, "com.obric.memorydata.plugin"), new com.obric.dejavu.library.cipher.a(r9.a(), r9.b(), r9.c()), r13, r14));
        L13:
            return new DbObjResult(b.f7881a.a(), null);
        }
    }

    static {
        c = new a(null);
    }

    public DbCipherInstanceImpl(com.obric.dejavu.library.c r2, com.obric.dejavu.library.cipher.a r3, adcpeJava.adcpe.c r4, adcpeJava.adcpe.b r5) {
        Intrinsics.checkNotNullParameter(r2, "dbInstance");
        Intrinsics.checkNotNullParameter(r3, "cryptoOpt");
        Intrinsics.checkNotNullParameter(r4, "encryptor");
        Intrinsics.checkNotNullParameter(r5, "decryptor");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        Gson r6 = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(c.class, Type.class, "com.obric.memorydata.plugin"), new DbCipherExtraInfoDeserializer()).create();
        Intrinsics.checkNotNullExpressionValue(r6, "GsonBuilder()\n        .r…izer())\n        .create()");
        this.h = r6;
    }

    private final adcpeJava.adcpe.a a(float[] r1, boolean r2) {
        double[] r3 = a(r1);
        if (r2 == false) goto L5;
        adcpeJava.adcpe.a r0 = this.f.a(r3);     // Catch: Exception -> L7
    L10:
        return r0;
    L5:
        r0 = this.f.b(r3);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Log.e("DbCipherInstanceImpl", "catch Exception: " + e.getMessage());
        return (adcpeJava.adcpe.a) ZeusTransformUtils.preCheckCast(null, adcpeJava.adcpe.a.class, "com.obric.memorydata.plugin");
    }

    private final double[] a(float[] r5) {
        int r4 = r5.length;
        double[] r0 = new double[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = r5[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private final float[] a(adcpeJava.adcpe.a r4) {
        double[] r5 = this.g.a(r4);     // Catch: Exception -> L5
    L7:
        if (r5 != null) goto L9;
        return null;
    L9:
        return a(r5);
    L5:
        e = move-exception;
        Log.e("DbCipherInstanceImpl", "catch Exception: " + e.getMessage());
        r5 = (double[]) ZeusTransformUtils.preCheckCast(null, double[].class, "com.obric.memorydata.plugin");
        goto L7
    }

    private final float[] a(double[] r5) {
        int r4 = r5.length;
        float[] r0 = new float[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = (float) r5[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // com.obric.dejavu.library.c
    public DbKvResult a(String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (r5 == false) goto L5;
        DbKvResult r7 = this.d.a(r4, true, r6);
        if (Intrinsics.areEqual(r7.getStatus(), DbStatus.f7870a.a()) == true) goto L10;
        Log.e("DbCipherInstanceImpl", "search by key failed, dbKvResult.status: " + r7.getStatus());
        return r7;
    L10:
        String r8 = null;
        String r1 = r7.getValue();     // Catch: Exception -> L17
        if (r1 == null) goto L20;
        c r3 = (c) ZeusTransformUtils.preCheckCast(this.h.fromJson(r1, c.class), c.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        if (r3 == null) goto L20;
        r8 = r3.a();     // Catch: Exception -> L17
    L20:
        return new DbKvResult(r7.getStatus(), r7.getVec(), r8);
    L17:
        e = move-exception;
        Log.e("DbCipherInstanceImpl", "Failed to parse JSON: " + r7.getValue() + " catch Exception: " + e.getMessage());
        r8 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        goto L20
    L5:
        return this.d.a(r4, false, r6);
    }

    @Override // com.obric.dejavu.library.c
    public DbObjResult<Pair<String, Float>[][]> a(float[][] r8, int r9, com.obric.dejavu.library.e r10) {
        Intrinsics.checkNotNullParameter(r8, "vecs");
        Intrinsics.checkNotNullParameter(r10, "opt");
        Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r11.length), Collection.class, "com.obric.memorydata.plugin");
        int r2 = r11.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L13;
        adcpeJava.adcpe.a r5 = a((float[]) ZeusTransformUtils.preCheckCast(r11[r4], float[].class, "com.obric.memorydata.plugin"), true);
        if (r5 == null) goto L7;
        float[] r6 = r5.b();
    L8:
        if (r6 != null) goto L10;
        r6 = new float[0];
    L11:
        r0.add(r6);
        r4 = r4 + 1;
        goto L3
    L10:
        Intrinsics.checkNotNullExpressionValue(r6, "vecEncrypt(vec, true)?.floatC() ?: FloatArray(0)");
        goto L11
    L7:
        r6 = null;
        goto L8
    L13:
        return this.d.a((float[][]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new float[0][]), float[][].class, "com.obric.memorydata.plugin"), r9, r10);
    }

    @Override // com.obric.dejavu.library.c
    public DbStatus a() {
        return this.d.a();
    }

    @Override // com.obric.dejavu.library.c
    public DbStatus a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.d.a(r2);
    }

    @Override // com.obric.dejavu.library.c
    public long b() {
        return this.d.b();
    }

    @Override // com.obric.dejavu.library.cipher.d
    public DbKvResult b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Log.d("DbCipherInstanceImpl", "searchAndDecrypt key: " + r8);
        boolean r2 = true;
        DbKvResult r9 = this.d.a(r8, true, true);
        DbStatus r0 = r9.getStatus();
        if (Intrinsics.areEqual(r0, DbStatus.f7870a.a()) == true) goto L6;
        Log.e("DbCipherInstanceImpl", "code: " + r0.a() + ", msg: " + r0.b());
        return r9;
    L6:
        float[] r1 = r9.getVec();
        String r10 = r9.getValue();
        if (r10 != null) goto L36;
        c r11 = null;
    L13:
        if (r1 == null) goto L34;
        if (r11 == null) goto L34;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L18;
    L21:
        if (r2 == true) goto L34;
        adcpeJava.adcpe.a r3 = adcpeJava.adcpe.a.a(r1, r11.b());     // Catch: Exception -> L31
        if (r3 == null) goto L26;
        float[] r7 = a(r3);
    L27:
        if (r7 != null) goto L30;
        Log.e("DbCipherInstanceImpl", "searchAndDecrypt: decrypt vec failed");
        return new DbKvResult(b.f7881a.d(), null, null);
    L30:
        return new DbKvResult(DbStatus.f7870a.a(), r7, r11.a());
    L26:
        r7 = null;
    L31:
        e = move-exception;
        Log.e("DbCipherInstanceImpl", "searchAndDecrypt: failed to parse Ciphertext", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return new DbKvResult(b.f7881a.d(), null, null);
    L18:
        if (r5.length() == 0) goto L21;
        r2 = false;
    L34:
        Log.e("DbCipherInstanceImpl", "searchAndDecrypt: invalid vec or extraInfo");
        return new DbKvResult(b.f7881a.d(), null, null);
    L36:
        r11 = (c) ZeusTransformUtils.preCheckCast(this.h.fromJson(r10, c.class), c.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("DbCipherInstanceImpl", "catch Exception: " + e.getMessage());
        r11 = (c) ZeusTransformUtils.preCheckCast(null, c.class, "com.obric.memorydata.plugin");
        goto L13
    }

    @Override // com.obric.dejavu.library.c
    public long c() {
        return this.d.c();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Log.d("DbCipherInstanceImpl", "DbCipherInstanceImpl close in");
        this.e.a("");
        this.e.a(0.1d);
        this.d.close();
    }

    @Override // com.obric.dejavu.library.c
    public String d() {
        return this.d.d();
    }

    @Override // com.obric.dejavu.library.c
    public DbStatus insert(String r4, float[] r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r6, EventBody.KEY_VALUE);
        float[] r0 = null;
        if (r5 == null) goto L5;
        adcpeJava.adcpe.a r8 = a(r5, false);
    L7:
        if (r8 == null) goto L9;
        String r2 = r8.g();
    L10:
        c r1 = new c(r6, r2);
        com.obric.dejavu.library.c r9 = this.d;
        if (r8 == null) goto L13;
        r0 = r8.d();
    L13:
        String r3 = this.h.toJson(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "gson.toJson(extraInfo)");
        return r9.insert(r4, r0, r3, r7);
    L9:
        r2 = null;
        goto L10
    L5:
        Log.e("DbCipherInstanceImpl", "insert: input vec is null");
        r8 = (adcpeJava.adcpe.a) ZeusTransformUtils.preCheckCast(null, adcpeJava.adcpe.a.class, "com.obric.memorydata.plugin");
        goto L7
    }
}
