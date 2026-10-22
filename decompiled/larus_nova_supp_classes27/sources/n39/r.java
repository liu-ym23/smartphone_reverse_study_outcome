package n39;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface r {
    void displayAsrText(Pair<String, String> r1);

    void startVoiceInput(Function1<? super String, Unit> r1);

    void stopVoiceInput(Function1<? super Integer, Unit> r1);
}
