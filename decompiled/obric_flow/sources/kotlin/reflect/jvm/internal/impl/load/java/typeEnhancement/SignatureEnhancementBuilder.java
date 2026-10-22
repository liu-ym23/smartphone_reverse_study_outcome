package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.exifinterface.media.ExifInterface;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
final class SignatureEnhancementBuilder {
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures;

    public final class ClassEnhancementBuilder {
        private final String className;
        final /* synthetic */ SignatureEnhancementBuilder this$0;

        @SourceDebugExtension({"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder$ClassEnhancementBuilder$FunctionEnhancementBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,254:1\n1208#2,2:255\n1238#2,4:257\n1208#2,2:261\n1238#2,4:263\n1549#2:267\n1620#2,3:268\n1549#2:271\n1620#2,3:272\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder$ClassEnhancementBuilder$FunctionEnhancementBuilder\n*L\n226#1:255,2\n226#1:257,4\n237#1:261,2\n237#1:263,4\n245#1:267\n245#1:268,3\n246#1:271\n246#1:272,3\n*E\n"})
        public final class FunctionEnhancementBuilder {
            private final String functionName;
            private final List<Pair<String, TypeEnhancementInfo>> parameters;
            private Pair<String, TypeEnhancementInfo> returnType;
            final /* synthetic */ ClassEnhancementBuilder this$0;

            public FunctionEnhancementBuilder(ClassEnhancementBuilder r5, String r10) {
                Intrinsics.checkNotNullParameter(r10, "functionName");
                this.this$0 = r5;
                this.functionName = r10;
                this.parameters = new ArrayList();
                this.returnType = TuplesKt.to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents r5 = SignatureBuildingComponents.INSTANCE;
                String r10 = this.this$0.getClassName();
                String r11 = this.functionName;
                List<Pair<String, TypeEnhancementInfo>> r12 = this.parameters;
                ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
                Iterator<T> r14 = r12.iterator();
            L4:
                if (r14.hasNext() == false) goto L6;
                r13.add((String) ((Pair) r14.next()).getFirst());
                goto L4
            L6:
                String r15 = r5.signature(r10, r5.jvmDescriptor(r11, r13, this.returnType.getFirst()));
                TypeEnhancementInfo r16 = this.returnType.getSecond();
                List<Pair<String, TypeEnhancementInfo>> r17 = this.parameters;
                ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
                Iterator<T> r19 = r17.iterator();
            L8:
                if (r19.hasNext() == false) goto L11;
                r18.add((TypeEnhancementInfo) ((Pair) r19.next()).getSecond());
                goto L8
            L11:
                return TuplesKt.to(r15, new PredefinedFunctionEnhancementInfo(r16, r18));
            }

            public final void parameter(String r5, JavaTypeQualifiers... r10) {
                Intrinsics.checkNotNullParameter(r5, "type");
                Intrinsics.checkNotNullParameter(r10, "qualifiers");
                List<Pair<String, TypeEnhancementInfo>> r11 = this.parameters;
                if (r10.length != 0) goto L5;
                TypeEnhancementInfo r12 = null;
            L10:
                r11.add(TuplesKt.to(r5, r12));
                return;
            L5:
                Iterable r13 = ArraysKt.withIndex(r10);
                LinkedHashMap r14 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r13)), 16));
                Iterator r15 = r13.iterator();
            L7:
                if (r15.hasNext() == false) goto L9;
                IndexedValue r16 = (IndexedValue) r15.next();
                r14.put(Integer.valueOf(r16.getIndex()), (JavaTypeQualifiers) r16.getValue());
                goto L7
            L9:
                r12 = new TypeEnhancementInfo(r14);
                goto L10
            }

            public final void returns(String r5, JavaTypeQualifiers... r10) {
                Intrinsics.checkNotNullParameter(r5, "type");
                Intrinsics.checkNotNullParameter(r10, "qualifiers");
                Iterable r11 = ArraysKt.withIndex(r10);
                LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r11)), 16));
                Iterator r13 = r11.iterator();
            L4:
                if (r13.hasNext() == false) goto L6;
                IndexedValue r14 = (IndexedValue) r13.next();
                r12.put(Integer.valueOf(r14.getIndex()), (JavaTypeQualifiers) r14.getValue());
                goto L4
            L6:
                this.returnType = TuplesKt.to(r5, new TypeEnhancementInfo(r12));
            }

            public final void returns(JvmPrimitiveType r5) {
                Intrinsics.checkNotNullParameter(r5, "type");
                this.returnType = TuplesKt.to(r5.getDesc(), null);
            }
        }

        public ClassEnhancementBuilder(SignatureEnhancementBuilder r5, String r10) {
            Intrinsics.checkNotNullParameter(r10, "className");
            this.this$0 = r5;
            this.className = r10;
        }

        public final void function(String r5, Function1<? super FunctionEnhancementBuilder, Unit> r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "block");
            Map r11 = SignatureEnhancementBuilder.access$getSignatures$p(this.this$0);
            FunctionEnhancementBuilder r12 = new FunctionEnhancementBuilder(this, r5);
            r10.invoke(r12);
            Pair<String, PredefinedFunctionEnhancementInfo> r13 = r12.build();
            r11.put(r13.getFirst(), r13.getSecond());
        }

        public final String getClassName() {
            return this.className;
        }
    }

    public SignatureEnhancementBuilder() {
        this.signatures = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getSignatures$p(SignatureEnhancementBuilder r5) {
        return r5.signatures;
    }

    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }
}
