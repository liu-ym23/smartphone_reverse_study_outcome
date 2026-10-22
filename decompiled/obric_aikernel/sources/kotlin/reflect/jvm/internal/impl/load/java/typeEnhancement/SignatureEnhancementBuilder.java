package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
final class SignatureEnhancementBuilder {
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures;

    public final class ClassEnhancementBuilder {
        private final String className;
        final /* synthetic */ SignatureEnhancementBuilder this$0;

        public final class FunctionEnhancementBuilder {
            private final String functionName;
            private final List<Pair<String, TypeEnhancementInfo>> parameters;
            private Pair<String, TypeEnhancementInfo> returnType;
            final /* synthetic */ ClassEnhancementBuilder this$0;

            public FunctionEnhancementBuilder(ClassEnhancementBuilder r10, String r11) {
                Intrinsics.checkNotNullParameter(r11, "functionName");
                this.this$0 = r10;
                this.functionName = r11;
                this.parameters = new ArrayList();
                this.returnType = TuplesKt.to("V", null);
            }

            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents r10 = SignatureBuildingComponents.INSTANCE;
                String r11 = this.this$0.getClassName();
                String r12 = this.functionName;
                List<Pair<String, TypeEnhancementInfo>> r13 = this.parameters;
                ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
                Iterator<T> r15 = r13.iterator();
            L4:
                if (r15.hasNext() == false) goto L6;
                r14.add((String) ((Pair) r15.next()).getFirst());
                goto L4
            L6:
                String r16 = r10.signature(r11, r10.jvmDescriptor(r12, r14, this.returnType.getFirst()));
                TypeEnhancementInfo r17 = this.returnType.getSecond();
                List<Pair<String, TypeEnhancementInfo>> r18 = this.parameters;
                ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
                Iterator<T> r20 = r18.iterator();
            L8:
                if (r20.hasNext() == false) goto L11;
                r19.add((TypeEnhancementInfo) ((Pair) r20.next()).getSecond());
                goto L8
            L11:
                return TuplesKt.to(r16, new PredefinedFunctionEnhancementInfo(r17, r19));
            }

            public final void parameter(String r10, JavaTypeQualifiers... r11) {
                Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
                Intrinsics.checkNotNullParameter(r11, "qualifiers");
                List<Pair<String, TypeEnhancementInfo>> r12 = this.parameters;
                if (r11.length != 0) goto L5;
                boolean r13 = true;
            L6:
                if (r13 == false) goto L8;
                TypeEnhancementInfo r14 = null;
            L13:
                r12.add(TuplesKt.to(r10, r14));
                return;
            L8:
                Iterable r15 = ArraysKt.withIndex(r11);
                LinkedHashMap r16 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16));
                Iterator r17 = r15.iterator();
            L10:
                if (r17.hasNext() == false) goto L12;
                IndexedValue r18 = (IndexedValue) r17.next();
                r16.put(Integer.valueOf(r18.getIndex()), (JavaTypeQualifiers) r18.getValue());
                goto L10
            L12:
                r14 = new TypeEnhancementInfo(r16);
                goto L13
            L5:
                r13 = false;
                goto L6
            }

            public final void returns(String r10, JavaTypeQualifiers... r11) {
                Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
                Intrinsics.checkNotNullParameter(r11, "qualifiers");
                Iterable r12 = ArraysKt.withIndex(r11);
                LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));
                Iterator r14 = r12.iterator();
            L4:
                if (r14.hasNext() == false) goto L6;
                IndexedValue r15 = (IndexedValue) r14.next();
                r13.put(Integer.valueOf(r15.getIndex()), (JavaTypeQualifiers) r15.getValue());
                goto L4
            L6:
                this.returnType = TuplesKt.to(r10, new TypeEnhancementInfo(r13));
            }

            public final void returns(JvmPrimitiveType r10) {
                Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
                String r11 = r10.getDesc();
                Intrinsics.checkNotNullExpressionValue(r11, "type.desc");
                this.returnType = TuplesKt.to(r11, null);
            }
        }

        public ClassEnhancementBuilder(SignatureEnhancementBuilder r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "className");
            this.this$0 = r10;
            this.className = r11;
        }

        public final void function(String r10, Function1<? super FunctionEnhancementBuilder, Unit> r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "block");
            Map r12 = SignatureEnhancementBuilder.access$getSignatures$p(this.this$0);
            FunctionEnhancementBuilder r13 = new FunctionEnhancementBuilder(this, r10);
            r11.invoke(r13);
            Pair<String, PredefinedFunctionEnhancementInfo> r14 = r13.build();
            r12.put(r14.getFirst(), r14.getSecond());
        }

        public final String getClassName() {
            return this.className;
        }
    }

    public SignatureEnhancementBuilder() {
        this.signatures = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getSignatures$p(SignatureEnhancementBuilder r10) {
        return r10.signatures;
    }

    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }
}
