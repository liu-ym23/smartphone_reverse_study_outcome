package w4b;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b0 {
    void a(Context r1, String r2, String r3);

    void b(Context r1, y6b.b r2, Chat r3);

    void c(Context r1, Bundle r2);

    void e(Context r1, ProfileSource r2);

    ArrayList<BaseField> parseFields(List<GetUserProfileResponse.Field> r1);
}
