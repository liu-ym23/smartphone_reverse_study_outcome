package o1;

import androidx.core.util.Consumer;
import com.google.gson.JsonObject;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    List getAltNames();

    String getName();

    boolean mustRunInMain();

    void realHandle(n1.c r5, JsonObject r10, Consumer r11, Consumer r12);
}
