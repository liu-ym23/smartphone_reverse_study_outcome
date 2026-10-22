package com.obric.aikernel.model.device.encrypt;

import androidx.annotation.Keep;
import com.google.gson.d;
import com.google.gson.reflect.TypeToken;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.common.CommonNetworkImpl;
import com.obric.aikernel.model.cloud.common.c;
import com.obric.aikernel.model.cloud.common.e;
import com.obric.aikernel.model_decrypt.api.callback.IKeyInfoDistribute;
import com.obric.aikernel.utils.GsonExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyInfoDistributeImpl implements IKeyInfoDistribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy<String> f4683b = null;

    @Keep
    public static final class ModelDecryptKeyInfoResponse {
        private final Map<String, ScriptModelInfo> models;

        /* JADX WARN: Multi-variable type inference failed */
        public ModelDecryptKeyInfoResponse() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public ModelDecryptKeyInfoResponse(Map<String, ScriptModelInfo> r10) {
            this.models = r10;
        }

        public /* synthetic */ ModelDecryptKeyInfoResponse(Map r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = null;
        L5:
            this(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ModelDecryptKeyInfoResponse copy$default(ModelDecryptKeyInfoResponse r10, Map r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r11 = r10.models;
        L6:
            return r10.copy(r11);
        }

        public final Map<String, ScriptModelInfo> component1() {
            return this.models;
        }

        public final ModelDecryptKeyInfoResponse copy(Map<String, ScriptModelInfo> r10) {
            return new ModelDecryptKeyInfoResponse(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ModelDecryptKeyInfoResponse) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.models, ((ModelDecryptKeyInfoResponse) r10).models) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final Map<String, ScriptModelInfo> getModels() {
            return this.models;
        }

        public int hashCode() {
            Map<String, ScriptModelInfo> r10 = this.models;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.hashCode();
        }

        public String toString() {
            return "ModelDecryptKeyInfoResponse(models=" + this.models + ')';
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ String a(a r10) {
            return r10.b();
        }

        private final String b() {
            return (String) KeyInfoDistributeImpl.a().getValue();
        }
    }

    public static final class b extends TypeToken<com.obric.aikernel.model.cloud.common.a<ModelDecryptKeyInfoResponse>> {
        b() {
        }
    }

    static {
        f4682a = new a(null);
        f4683b = LazyKt.lazy(KeyInfoDistributeImpl$Companion$KEY_INFO_API_PATH$2.INSTANCE);
    }

    public KeyInfoDistributeImpl() {
    }

    public static final /* synthetic */ Lazy a() {
        return f4683b;
    }

    @Override // com.obric.aikernel.model_decrypt.api.callback.IKeyInfoDistribute
    /* JADX INFO: renamed from: onRequestKeyInfo-BWLJW6A, reason: not valid java name */
    public Object mo17onRequestKeyInfoBWLJW6A(String r10, String r11, Set<String> r12, Continuation<? super Result<? extends Set<IKeyInfoDistribute.KeyInfoItem>>> r13) {
        AIKLog.INSTANCE.d("KeyInfoDistributeImpl", "requestKeyInfo: keyAlias: " + r10 + ", modelNames: " + r12);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L64
        LinkedHashSet r15 = new LinkedHashSet();     // Catch: Throwable -> L64
        c r16 = e.a.b(CommonNetworkImpl.f4638a.m(), a.a(f4682a), MapsKt.mapOf(new Pair[]{TuplesKt.to("aikernel_model", r12), TuplesKt.to("x_att_certchain", r11)}), null, MapsKt.mapOf(TuplesKt.to("X-Distribute", "ai_kernel")), 4, null);     // Catch: Throwable -> L64
        if (r16.i() == false) goto L63;
        d r17 = GsonExtKt.a();     // Catch: Throwable -> L64
        String r18 = r16.b();     // Catch: Throwable -> L64
        if (r18 != null) goto L10;
        r18 = "";
    L10:
        com.obric.aikernel.model.cloud.common.a r19 = (com.obric.aikernel.model.cloud.common.a) r17.l(r18, new b().getType());     // Catch: Throwable -> L64
        if (r19.d() == false) goto L61;
        ModelDecryptKeyInfoResponse r20 = (ModelDecryptKeyInfoResponse) r19.b();     // Catch: Throwable -> L64
        if (r20 == null) goto L83;
        Map<String, ScriptModelInfo> r21 = r20.getModels();     // Catch: Throwable -> L64
        if (r21 == null) goto L83;
        Collection<ScriptModelInfo> r22 = r21.values();     // Catch: Throwable -> L64
        if (r22 == null) goto L83;
        Iterator<T> r23 = r22.iterator();     // Catch: Throwable -> L64
    L20:
        if (r23.hasNext() == false) goto L83;
        ScriptModelInfo r110 = (ScriptModelInfo) r23.next();     // Catch: Throwable -> L64
        List<ScriptModelFile> r24 = r110.getWeight_files();     // Catch: Throwable -> L64
        ArrayList r25 = new ArrayList();     // Catch: Throwable -> L64
        Iterator<T> r26 = r24.iterator();     // Catch: Throwable -> L64
    L23:
        if (r26.hasNext() == false) goto L32;
        Object r27 = r26.next();     // Catch: Throwable -> L64
        ScriptModelFile r28 = (ScriptModelFile) r27;     // Catch: Throwable -> L64
        if (com.obric.aikernel.model.device.encrypt.a.b(r28) == true) goto L27;
    L29:
        boolean r29 = false;
    L30:
        if (r29 == false) goto L23;
        r25.add(r27);     // Catch: Throwable -> L64
        goto L23
    L27:
        if (com.obric.aikernel.model.device.encrypt.a.a(r28) == false) goto L29;
        r29 = true;
        goto L30
    L32:
        Iterator r30 = r25.iterator();     // Catch: Throwable -> L64
    L35:
        if (r30.hasNext() == false) goto L43;
        ScriptModelFile r31 = (ScriptModelFile) r30.next();     // Catch: Throwable -> L64
        String r32 = com.obric.aikernel.model.device.encrypt.b.a(r110);     // Catch: Throwable -> L64
        String r33 = r31.getFilename();     // Catch: Throwable -> L64
        String r34 = r31.getEncrypt_key_info();     // Catch: Throwable -> L64
        if (r34 != null) goto L39;
        r34 = "";
    L39:
        IKeyInfoDistribute.KeyInfoItem r35 = new IKeyInfoDistribute.KeyInfoItem(r32, r33, r34);     // Catch: Throwable -> L64
        AIKLog r36 = AIKLog.INSTANCE;     // Catch: Throwable -> L64
        if (r36.isDebug() == false) goto L42;
        r36.d("KeyInfoDistributeImpl", "onRequestKeyInfo: key_info " + r35);     // Catch: Throwable -> L64
    L42:
        r15.add(r35);     // Catch: Throwable -> L64
        goto L35
    L43:
        ScriptModelFile r37 = r110.getTokenizer_file();     // Catch: Throwable -> L64
        if (r37 != null) goto L46;
    L48:
        boolean r38 = false;
    L49:
        if (r38 == false) goto L20;
        if (com.obric.aikernel.model.device.encrypt.a.a(r110.getTokenizer_file()) == false) goto L20;
        String r39 = com.obric.aikernel.model.device.encrypt.b.a(r110);     // Catch: Throwable -> L64
        String r40 = r110.getTokenizer_file().getFilename();     // Catch: Throwable -> L64
        String r111 = r110.getTokenizer_file().getEncrypt_key_info();     // Catch: Throwable -> L64
        if (r111 != null) goto L55;
        r111 = "";
    L55:
        IKeyInfoDistribute.KeyInfoItem r41 = new IKeyInfoDistribute.KeyInfoItem(r39, r40, r111);     // Catch: Throwable -> L64
        AIKLog r112 = AIKLog.INSTANCE;     // Catch: Throwable -> L64
        if (r112.isDebug() == false) goto L58;
        r112.d("KeyInfoDistributeImpl", "onRequestKeyInfo: key_info " + r41);     // Catch: Throwable -> L64
    L58:
        r15.add(r41);     // Catch: Throwable -> L64
        goto L20
    L46:
        if (com.obric.aikernel.model.device.encrypt.a.b(r37) != true) goto L48;
        r38 = true;
    L83:
        return Result.m32constructorimpl(r15);
    L61:
        throw new Exception("requestKeyInfo failed: code = " + r19.a() + ", message = " + r19.c());     // Catch: Throwable -> L64
    L63:
        throw new Exception("requestKeyInfo failed: status = " + r16.f() + ", message = " + r16.e());     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        return Result.m32constructorimpl(ResultKt.createFailure(th));
    }
}
