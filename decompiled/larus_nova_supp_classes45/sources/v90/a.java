package v90;

import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends BaseEmoji {
    public a(boolean r2) {
        setType(BaseEmoji.Type.DeleteEmoji);
        if (r2 == false) goto L5;
        setIconId(2131250535);
        return;
    L5:
        setIconId(2131250529);
    }
}
