package pea;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface l {

    public static final class a {
        public static /* synthetic */ k a(l r1) {
            return r1.create(Boolean.FALSE);
        }
    }

    k create(Boolean r1);

    Bundle getActions();

    Bundle getPics();

    JSONObject toJSONObject();
}
