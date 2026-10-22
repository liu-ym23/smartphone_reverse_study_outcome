package com.obric.memorydata.personalcontext.impl;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.personalcontext.util.c;
import com.obric.memorydata.personalcontext.vectordb.d;
import com.obric.memorydata.personalcontext.vectordb.f;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0000H\u0007J2\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J<\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016JK\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0013J2\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J<\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016JK\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J \u0010\u001c\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016J*\u0010#\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0016JB\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0016JP\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u001a\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016J\"\u0010/\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010 H\u0016J\u001a\u00101\u001a\u0004\u0018\u00010 2\u0006\u0010'\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0018H\u0002J$\u00103\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u0002042\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/VectorDbBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IVectorDbBridgeAPI;", "<init>", "()V", "TAG", "", "SEARCH_WITH_KEYS_PARALLELISM", "", "getInst", "queryByVector", "", "Lkotlin/Pair;", "", "", "table", "vectorString", "limit", "foregroundCallerPkg", "minDistance", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Float;)Ljava/util/List;", "queryByImageVector", "prepareToOpenVectorDb", "", "isVlm", "", "deleteVectorData", "rowid", "cleanTable", "insertVectorData", OaidModel.KEY_ID, Params.CONTENT, "queryVector", "", "vectorDbName", "key", "insertImageVector", "uri", "sourcePkg", "search", ChatMessage.TYPE_QUERY, "queryType", "extras", "Lorg/json/JSONObject;", "searchWithKeys", "keys", "getVectorDbSize", "searchAndDecrypt", "insertVector", "vector", "textEmbeddingToVector", "useVlm", "imageEmbeddingToVector", "Landroid/net/Uri;", "VectorQueryType", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorDbBridgeAPIImpl implements IVectorDbBridgeAPI {
    public static final VectorDbBridgeAPIImpl INSTANCE = null;
    private static final int SEARCH_WITH_KEYS_PARALLELISM = 2;
    public static final String TAG = "VectorDbBridgeAPIImpl";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/VectorDbBridgeAPIImpl$VectorQueryType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TEXT", "IMAGE", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum VectorQueryType extends Enum<VectorQueryType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ VectorQueryType[] $VALUES = null;
        public static final a Companion = null;
        public static final VectorQueryType IMAGE = null;
        public static final VectorQueryType TEXT = null;
        private final String type;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/VectorDbBridgeAPIImpl$VectorQueryType$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/personalcontext/impl/VectorDbBridgeAPIImpl$VectorQueryType;", EventBody.KEY_VALUE, "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final VectorQueryType a(String r5) {
                Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
                VectorQueryType[] r4 = VectorQueryType.values();
                int r0 = r4.length;
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L8;
                VectorQueryType r2 = r4[r1];
                if (Intrinsics.areEqual(r2.getType(), r5) == true) goto L12;
                r1 = r1 + 1;
                goto L3
            L12:
                return r2;
            L8:
                return null;
            }
        }

        private static final /* synthetic */ VectorQueryType[] $values() {
            return new VectorQueryType[]{TEXT, IMAGE};
        }

        static {
            TEXT = new VectorQueryType("TEXT", 0, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            IMAGE = new VectorQueryType("IMAGE", 1, "image");
            VectorQueryType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private VectorQueryType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }

        public static EnumEntries<VectorQueryType> getEntries() {
            return $ENTRIES;
        }

        public static VectorQueryType valueOf(String r2) {
            return (VectorQueryType) ZeusTransformUtils.preCheckCast(Enum.valueOf(VectorQueryType.class, r2), VectorQueryType.class, "com.obric.memorydata.plugin");
        }

        public static VectorQueryType[] values() {
            return (VectorQueryType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VectorQueryType[].class, "com.obric.memorydata.plugin");
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12188a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12189b = null;

        static {
            int[] r0 = new int[EmbeddingState.values().length];
            r0[EmbeddingState.USE_VLM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[EmbeddingState.USE_LITTLE_MODEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f12188a = r0;
            int[] r1 = new int[VectorQueryType.values().length];
            r1[VectorQueryType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[VectorQueryType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f12189b = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.impl.VectorDbBridgeAPIImpl$imageEmbeddingToVector$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.impl.VectorDbBridgeAPIImpl$imageEmbeddingToVector$1", f = "VectorDbBridgeAPIImpl.kt", i = {}, l = {429}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
        final /* synthetic */ String $sourcePkg;
        final /* synthetic */ Uri $uri;
        final /* synthetic */ boolean $useVlm;
        int label;

        AnonymousClass1(Uri r3, String r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$uri = r3;
            this.$sourcePkg = r4;
            this.$useVlm = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$uri, this.$sourcePkg, this.$useVlm, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super float[]> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            com.obric.memorydata.aikernelcore.a r2 = com.obric.memorydata.aikernelcore.a.INSTANCE;
            Uri r12 = this.$uri;
            String r3 = this.$sourcePkg;
            boolean r6 = this.$useVlm;
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r11 = com.obric.memorydata.aikernelcore.a.a(r2, r12, r3, null, false, r6, r7, 12, null);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.impl.VectorDbBridgeAPIImpl$textEmbeddingToVector$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.impl.VectorDbBridgeAPIImpl$textEmbeddingToVector$1", f = "VectorDbBridgeAPIImpl.kt", i = {}, l = {421}, m = "invokeSuspend", n = {}, s = {})
    static final class C12171 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
        final /* synthetic */ String $query;
        final /* synthetic */ boolean $useVlm;
        int label;

        C12171(String r3, boolean r4, Continuation<? super C12171> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$query = r3;
            this.$useVlm = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12171(this.$query, this.$useVlm, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super float[]> r4) {
            return ((C12171) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12171.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            com.obric.memorydata.aikernelcore.a r2 = com.obric.memorydata.aikernelcore.a.INSTANCE;
            String r11 = this.$query;
            boolean r5 = this.$useVlm;
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r10 = com.obric.memorydata.aikernelcore.a.a(r2, r11, null, false, r5, r6, 6, null);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    static {
        INSTANCE = new VectorDbBridgeAPIImpl();
    }

    private VectorDbBridgeAPIImpl() {
    }

    @JvmStatic
    public static final VectorDbBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private final float[] imageEmbeddingToVector(Uri r2, String r3, boolean r4) {
        return (float[]) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$Hos2k77UHY5Vzy7-YnUG5Hapoo8, reason: not valid java name */
    public static /* synthetic */ void m1079lambda$Hos2k77UHY5Vzy7YnUG5Hapoo8(String r0, boolean r1) {
        prepareToOpenVectorDb$lambda$0(r0, r1);
    }

    private final void prepareToOpenVectorDb(final String r2, final boolean r3) {
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$VectorDbBridgeAPIImpl$Hos2k77UHY5Vzy7YnUG5Hapoo8(r2, r3));
    }

    private static final void prepareToOpenVectorDb$lambda$0(String r1, boolean r2) {
        f.f12411a.a(r1, r2);
    }

    public static /* synthetic */ List queryByImageVector$default(VectorDbBridgeAPIImpl r6, String r7, String r8, int r9, String r10, Float r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r6.queryByImageVector(r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ List queryByVector$default(VectorDbBridgeAPIImpl r6, String r7, String r8, int r9, String r10, Float r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r6.queryByVector(r7, r8, r9, r10, r11);
    }

    private final float[] textEmbeddingToVector(String r2, boolean r3) {
        return (float[]) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C12171(r2, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean cleanTable(String r15) {
        Intrinsics.checkNotNullParameter(r15, "table");
        int r14 = a.f12188a[c.f12363a.b().ordinal()];
        if (r14 != 1) goto L5;
        boolean r16 = new d(r15, true).b();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "clear " + r15 + " resultVlm: " + r16 + ' ', false, 4, null);
        return r16;
    L5:
        if (r14 == 2) goto L12;
        boolean r17 = new d(r15, true).b();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "clear " + r15 + " resultVlm: " + r17 + ' ', false, 4, null);
        boolean r0 = new d(r15, false).b();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "clear " + r15 + " resultModel: " + r0 + ' ', false, 4, null);
        if (r17 == false) goto L11;
        if (r0 == false) goto L11;
        return true;
    L11:
        return false;
    L12:
        boolean r18 = new d(r15, false).b();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "clear " + r15 + " resultModel: " + r18 + ' ', false, 4, null);
        return r18;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean deleteVectorData(String r21, int r22) {
        Intrinsics.checkNotNullParameter(r21, "table");
        int r2 = a.f12188a[c.f12363a.b().ordinal()];
        if (r2 != 1) goto L5;
        boolean r3 = new d(r21, true).delete(r22);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete " + r21 + " rowId: " + r22 + " resultVlm: " + r3 + ' ', false, 4, null);
        return r3;
    L5:
        if (r2 == 2) goto L12;
        long r12 = r22;
        boolean r4 = new d(r21, true).delete(r12);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete " + r21 + " rowId: " + r22 + " resultVlm: " + r4 + ' ', false, 4, null);
        boolean r5 = new d(r21, false).delete(r12);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete " + r21 + " rowId: " + r22 + " resultModel: " + r5 + ' ', false, 4, null);
        if (r4 == false) goto L11;
        if (r5 == false) goto L11;
        return true;
    L11:
        return false;
    L12:
        boolean r6 = new d(r21, false).delete(r22);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete " + r21 + " rowId: " + r22 + " resultModel: " + r6 + ' ', false, 4, null);
        return r6;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public long getVectorDbSize(String r11) {
        Intrinsics.checkNotNullParameter(r11, "table");
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r10 = true;
    L6:
        long r0 = SystemClock.elapsedRealtime();
        long r2 = new d(r11, r10).a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getVectorDbSize table=" + r11 + " size=" + r2 + " cost=" + (SystemClock.elapsedRealtime() - r0) + "ms", false, 4, null);
        return r2;
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean insertImageVector(String r21, long r22, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r21, "table");
        Intrinsics.checkNotNullParameter(r24, "uri");
        int r5 = a.f12188a[c.f12363a.b().ordinal()];
        if (r5 != 1) goto L5;
        float[] r0 = imageEmbeddingToVector(Uri.parse(r24), r25, true);
        if (r0 != null) goto L46;
    L53:
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("insert ").append(r21).append(" image vector(vlm) failed");
    L41:
        IRunLog.a.b(r1, TAG, r2.toString(), null, 4, null);
        return false;
    L46:
        if (r0.length != 0) goto L48;
        boolean r4 = true;
    L50:
        if ((!r4) == false) goto L53;
        return new d(r21, true).insert(r22, r0);
    L48:
        r4 = false;
        goto L50
    L5:
        if (r5 == 2) goto L30;
        float[] r6 = imageEmbeddingToVector(Uri.parse(r24), r25, true);
        if (r6 != null) goto L9;
    L15:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert " + r21 + " image vector(vlm) failed", null, 4, null);
        boolean r7 = false;
    L16:
        float[] r3 = imageEmbeddingToVector(Uri.parse(r24), r25, false);
        if (r3 != null) goto L19;
    L25:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert " + r21 + " image vector(model) failed", null, 4, null);
        boolean r8 = false;
    L26:
        if (r7 == false) goto L54;
        if (r8 == true) goto L29;
        return false;
    L29:
        return true;
    L54:
        return false;
    L19:
        if (r3.length != 0) goto L21;
        boolean r9 = true;
    L23:
        if ((!r9) == false) goto L25;
        r8 = new d(r21, false).insert(r22, r3);
        goto L26
    L21:
        r9 = false;
        goto L23
    L9:
        if (r6.length != 0) goto L11;
        boolean r12 = true;
    L13:
        if ((!r12) == false) goto L15;
        r7 = new d(r21, true).insert(r22, r6);
        goto L16
    L11:
        r12 = false;
        goto L13
    L30:
        float[] r10 = imageEmbeddingToVector(Uri.parse(r24), r25, false);
        if (r10 != null) goto L33;
    L40:
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r2 = new StringBuilder().append("insert ").append(r21).append(" image vector(model) failed");
        goto L41
    L33:
        if (r10.length != 0) goto L35;
        boolean r11 = true;
    L37:
        if ((!r11) == false) goto L40;
        return new d(r21, false).insert(r22, r10);
    L35:
        r11 = false;
        goto L37
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean insertVector(String r3, long r4, float[] r6) {
        Intrinsics.checkNotNullParameter(r3, "table");
        boolean r2 = false;
        if (r6 != null) goto L6;
        return false;
    L6:
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L9;
        r2 = true;
    L9:
        return new d(r3, r2).insert(r4, r6);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public boolean insertVectorData(String r19, long r20, String r22) {
        Intrinsics.checkNotNullParameter(r19, "table");
        Intrinsics.checkNotNullParameter(r22, Params.CONTENT);
        int r5 = a.f12188a[c.f12363a.b().ordinal()];
        if (r5 != 1) goto L5;
        float[] r0 = textEmbeddingToVector(r22, true);
        if (r0 == null) goto L29;
        boolean r1 = new d(r19, true).insert(r20, r0);
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("insert ").append(r19).append(" resultVlm: ");
    L23:
        IRunLog.a.a(r9, TAG, r2.append(r1).toString(), false, 4, null);
        return r1;
    L29:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder().append("insert ").append(r19);
        String r6 = " vectorVlm failed";
    L18:
        IRunLog.a.b(r3, TAG, r4.append(r6).toString(), null, 4, null);
        return false;
    L5:
        if (r5 == 2) goto L20;
        float[] r7 = textEmbeddingToVector(r22, true);
        if (r7 == null) goto L9;
        boolean r8 = new d(r19, true).insert(r20, r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert " + r19 + " resultVlm: " + r8, false, 4, null);
    L10:
        float[] r10 = textEmbeddingToVector(r22, false);
        if (r10 == null) goto L13;
        boolean r11 = new d(r19, false).insert(r20, r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "insert " + r19 + " resultVlm: " + r11, false, 4, null);
    L14:
        if (r8 == false) goto L17;
        if (r11 == false) goto L17;
        return true;
    L17:
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r4 = new StringBuilder().append("insert ").append(r19);
        r6 = " vector failed";
        goto L18
    L13:
        r11 = false;
        goto L14
    L9:
        r8 = false;
        goto L10
    L20:
        float[] r12 = textEmbeddingToVector(r22, false);
        if (r12 == null) goto L25;
        r1 = new d(r19, false).insert(r20, r12);
        r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r2 = new StringBuilder().append("insert ").append(r19).append(" resultModel: ");
        goto L23
    L25:
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r4 = new StringBuilder().append("insert ").append(r19);
        r6 = " vectorModel failed";
        goto L18
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<Pair<Long, Float>> queryByImageVector(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "vectorString");
        return queryByImageVector(r2, r3, r4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<Pair<Long, Float>> queryByImageVector(String r8, String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "table");
        Intrinsics.checkNotNullParameter(r9, "vectorString");
        return queryByImageVector(r8, r9, r10, r11, null);
    }

    public final List<Pair<Long, Float>> queryByImageVector(String r7, String r8, int r9, String r10, Float r11) {
        Intrinsics.checkNotNullParameter(r7, "table");
        Intrinsics.checkNotNullParameter(r8, "vectorString");
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r0 = true;
    L6:
        prepareToOpenVectorDb(r7, r0);
        float[] r6 = com.obric.memorydata.personalcontext.util.d.f12365a.b(r8, r0, r10);
        if (r6 == null) goto L10;
        RunLog.INSTANCE.debug(TAG, "queryByImageVector vector(useVlm=" + r0 + ") table:" + r7 + ", text:" + r8 + ", limit:" + r9 + ", minDistance:" + r11 + ", foregroundCallerPkg:" + r10);
        return new d(r7, r0).a(r6, r9, r11);
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "query " + r7 + " vector failed", null, 4, null);
        return CollectionsKt.emptyList();
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<Pair<Long, Float>> queryByVector(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "vectorString");
        return queryByVector(r2, r3, r4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<Pair<Long, Float>> queryByVector(String r8, String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "table");
        Intrinsics.checkNotNullParameter(r9, "vectorString");
        return queryByVector(r8, r9, r10, r11, null);
    }

    public final List<Pair<Long, Float>> queryByVector(String r7, String r8, int r9, String r10, Float r11) {
        Intrinsics.checkNotNullParameter(r7, "table");
        Intrinsics.checkNotNullParameter(r8, "vectorString");
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r0 = true;
    L6:
        prepareToOpenVectorDb(r7, r0);
        float[] r6 = com.obric.memorydata.personalcontext.util.d.f12365a.a(r8, r0, r10);
        if (r6 == null) goto L10;
        RunLog.INSTANCE.debug(TAG, "queryByVector vector(useVlm=" + r0 + ") table:" + r7 + ", text:" + r8 + ", limit:" + r9 + ", minDistance:" + r11 + ", foregroundCallerPkg:" + r10);
        return new d(r7, r0).a(r6, r9, r11);
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "query " + r7 + " vector failed", null, 4, null);
        return CollectionsKt.emptyList();
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public float[] queryVector(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "vectorDbName");
        Intrinsics.checkNotNullParameter(r3, "key");
        return new d(r2, false).a(r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<Pair<Long, Float>> search(String r16, String r17, int r18, String r19, JSONObject r20) {
        Intrinsics.checkNotNullParameter(r16, "table");
        Intrinsics.checkNotNullParameter(r17, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r19, "queryType");
        Intrinsics.checkNotNullParameter(r20, "extras");
        boolean r6 = false;
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r4 = true;
    L6:
        VectorQueryType r5 = VectorQueryType.Companion.a(r19);
        if (r5 != null) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "search " + r16 + " queryType: " + r19 + " not support", null, 4, null);
        return CollectionsKt.emptyList();
    L10:
        prepareToOpenVectorDb(r16, r4);
        String r2 = r20.optString("foreground_pkg");
        int r3 = a.f12189b[r5.ordinal()];
        if (r3 != 1) goto L13;
        float[] r1 = com.obric.memorydata.personalcontext.util.d.f12365a.a(r17, r4, r2);
    L18:
        float[] r10 = r1;
        if (r10 != null) goto L21;
    L27:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "query " + r16 + " vector failed", null, 4, null);
        return CollectionsKt.emptyList();
    L21:
        if (r10.length != 0) goto L24;
        r6 = true;
    L24:
        if ((!r6) == false) goto L27;
        return com.obric.memorydata.personalcontext.vectordb.a.a((com.obric.memorydata.personalcontext.vectordb.a) ZeusTransformUtils.preCheckCast(new d(r16, r4), com.obric.memorydata.personalcontext.vectordb.a.class, "com.obric.memorydata.plugin"), r10, r18, null, 4, null);
    L13:
        if (r3 != 2) goto L16;
        r1 = com.obric.memorydata.personalcontext.util.d.f12365a.b(r17, r4, r2);
        goto L18
    L16:
        throw new NoWhenBranchMatchedException();
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public float[] searchAndDecrypt(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r3, "key");
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r1 = true;
    L7:
        return new d(r2, r1).a(r3);
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IVectorDbBridgeAPI
    public List<Pair<Long, Float>> searchWithKeys(String r13, String r14, List<Long> r15, int r16, String r17, JSONObject r18) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "table");
        Intrinsics.checkNotNullParameter(r14, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r5, "keys");
        Intrinsics.checkNotNullParameter(r17, "queryType");
        Intrinsics.checkNotNullParameter(r18, "extras");
        if (r5.isEmpty() == true) goto L39;
        if (r16 <= 0) goto L39;
        List<Long> r6 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));
        VectorQueryType r7 = VectorQueryType.Companion.a(r17);
        if (r7 == null) goto L37;
        boolean r9 = false;
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L11;
        boolean r8 = true;
    L12:
        prepareToOpenVectorDb(r13, r8);
        String r3 = r18.optString("foreground_pkg");
        int r10 = a.f12189b[r7.ordinal()];
        if (r10 != 1) goto L15;
        float[] r1 = com.obric.memorydata.personalcontext.util.d.f12365a.a(r14, r8, r3);
    L20:
        if (r1 != null) goto L22;
    L34:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "searchWithKeys " + r13 + " vector failed", null, 4, null);
        return CollectionsKt.emptyList();
    L22:
        if (r1.length != 0) goto L24;
        r9 = true;
    L24:
        if (r9 == true) goto L34;
        Double r4 = Double.valueOf(r18.optDouble("min_score", r18.optDouble("min_distance", Double.NaN)));
        Float r11 = null;
        if (Double.isNaN(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue()) == false) goto L30;
        r4 = null;
    L30:
        if (r4 == null) goto L32;
        r11 = Float.valueOf((float) r4.doubleValue());
    L32:
        long r12 = SystemClock.elapsedRealtime();
        List<Pair<Long, Float>> r2 = new d(r13, r8).a(r1, r6, r16, r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "searchWithKeys table=" + r13 + " keyCount=" + r6.size() + " limit=" + r16 + " resultCount=" + r2.size() + " parallelism=2 cost=" + (SystemClock.elapsedRealtime() - r12) + "ms", false, 4, null);
        return r2;
    L15:
        if (r10 != 2) goto L18;
        r1 = com.obric.memorydata.personalcontext.util.d.f12365a.b(r14, r8, r3);
        goto L20
    L18:
        throw new NoWhenBranchMatchedException();
    L11:
        r8 = false;
        goto L12
    L37:
        throw new IllegalArgumentException("searchWithKeys does not support queryType=" + r17);
    L39:
        return CollectionsKt.emptyList();
    }
}
