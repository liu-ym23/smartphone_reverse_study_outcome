package com.larksuite.component.blockit.props;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends ClickableSpan {
    public final String a;
    public final Map<String, Object> b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        JSONObject r0 = new JSONObject(this.b);
        r0.put("tag_id", this.a);     // Catch: JSONException -> L6
        r0.put("from", "view");     // Catch: JSONException -> L6
    L4:
        qy7.a.a("pano_panel_and_view_jump", r0);
        r4.getContext();
        ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).b();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        super.updateDrawState(r2);
        r2.setColor(UIHelper.getColor(2131103406));
        r2.setUnderlineText(false);
        r2.clearShadowLayer();
    }

    public b(String r1, String r2, Map<String, Object> r3) {
        this.a = r2;
        this.b = r3;
    }
}
