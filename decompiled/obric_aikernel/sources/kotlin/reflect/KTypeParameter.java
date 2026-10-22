package kotlin.reflect;

import java.util.List;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
public interface KTypeParameter extends KClassifier {
    String getName();

    List<KType> getUpperBounds();

    KVariance getVariance();

    boolean isReified();
}
