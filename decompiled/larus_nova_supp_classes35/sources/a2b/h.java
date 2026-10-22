package a2b;

import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface h {
    Object S0(List<String> r1, PrivateDescriptionSource r2, Strategy r3, Continuation<? super Result<? extends Map<String, UserPrivateDescription>>> r4);
}
