package kotlin.reflect;

import java.util.List;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes3.dex */
public interface KType extends KAnnotatedElement {

    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getArguments$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getClassifier$annotations() {
        }
    }

    List<KTypeProjection> getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}
