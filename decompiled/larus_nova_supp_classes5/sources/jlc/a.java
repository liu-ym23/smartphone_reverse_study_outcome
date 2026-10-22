package jlc;

import bytekn.foundation.logger.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectCategoryModel;
import com.ss.ugc.effectplatform.model.EffectCategoryResponse;
import com.ss.ugc.effectplatform.model.EffectChannelModel;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.UrlModel;
import com.ss.ugc.effectplatform.util.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final String a;
    public final String b;
    public final boolean c;

    /* JADX INFO: renamed from: jlc.a$a, reason: collision with other inner class name */
    public static final class C0019a {
    }

    static {
    }

    public final EffectChannelResponse a(EffectChannelModel r27) {
        HashMap r1 = new HashMap();
        HashMap r2 = new HashMap();
        Iterator<Effect> r3 = r27.getEffect_list().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Effect r4 = r3.next();
        r1.put(r4.getEffect_id(), r4);
        goto L4
    L6:
        Iterator<Effect> r5 = r27.getCollection_list().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Effect r6 = r5.next();
        r2.put(r6.getEffect_id(), r6);
        goto L8
    L10:
        EffectChannelResponse r7 = new EffectChannelResponse(null, null, null, null, null, null, null, null, null, 511, null);
        r7.setPanel(this.a);
        r7.setVersion(r27.getVersion());
        r7.setAll_category_effects(r27.getEffect_list());
        r7.setCollection_list(r27.getCollection_list());
        r7.setUrl_prefix(r27.getUrl_prefix());
        ArrayList r8 = new ArrayList();
        if ((!r27.getCategory_list().isEmpty()) == false) goto L52;
        Iterator<EffectCategoryModel> r9 = r27.getCategory_list().iterator();
    L14:
        if (r9.hasNext() == false) goto L52;
        EffectCategoryModel r10 = r9.next();
        String r24 = null;
        EffectCategoryResponse r15 = new EffectCategoryResponse(null, null, null, null, null, null, null, null, null, null, null, false, null, 8191, null);
        r15.setId(r10.getId());
        r15.setName(r10.getName());
        r15.setKey(r10.getKey());
        UrlModel r11 = r10.getIcon();
        if (r11 == null) goto L28;
        List<String> r12 = r11.getUrl_list();
        if (r12 == null) goto L28;
        if ((!r12.isEmpty()) != true) goto L28;
        UrlModel r13 = r10.getIcon();
        if (r13 == null) goto L26;
        List<String> r14 = r13.getUrl_list();
        if (r14 == null) goto L26;
        String r16 = (String) ListProtector.get(r14, 0);
    L27:
        r15.setIcon_normal_url(r16);
    L26:
        r16 = null;
    L28:
        UrlModel r17 = r10.getIcon_selected();
        if (r17 == null) goto L40;
        List<String> r18 = r17.getUrl_list();
        if (r18 == null) goto L40;
        if ((!r18.isEmpty()) != true) goto L40;
        UrlModel r19 = r10.getIcon_selected();
        if (r19 == null) goto L39;
        List<String> r20 = r19.getUrl_list();
        if (r20 == null) goto L39;
        r24 = (String) ListProtector.get(r20, 0);
    L39:
        r15.setIcon_selected_url(r24);
    L40:
        ArrayList r21 = new ArrayList();
        if (r10.getEffects() != null) goto L43;
        Logger.INSTANCE.d("BuildEffectChannelResponse", "categoryModel is null");
    L43:
        List<String> r22 = r10.getEffects();
        if (r22 == null) goto L51;
        Iterator<String> r23 = r22.iterator();
    L47:
        if (r23.hasNext() == false) goto L51;
        Effect r110 = (Effect) r1.get(r23.next());
        if (r110 == null) goto L47;
        r21.add(r110);
    L51:
        r15.setTotal_effects(r21);
        r15.setTags(r10.getTags());
        r15.setTags_update_time(r10.getTags_updated_at());
        r15.setCollection_effect(r27.getCollection_list());
        r15.setExtra(r10.getExtra());
        r15.set_default(r10.is_default());
        r8.add(r15);
    L52:
        r7.setCategory_responses(r8);
        Iterator<Effect> r25 = r27.getEffect_list().iterator();
    L54:
        if (r25.hasNext() == false) goto L68;
        Effect r26 = r25.next();
        if (r26.getEffect_type() != 1) goto L54;
        ArrayList r28 = new ArrayList();
        List<String> r29 = r26.getChildren();
        if (r29 != null) goto L61;
        r29 = new ArrayList();
    L61:
        Iterator<String> r30 = r29.iterator();
    L63:
        if (r30.hasNext() == false) goto L67;
        Effect r31 = (Effect) r2.get(r30.next());
        if (r31 == null) goto L63;
        r28.add(r31);
        goto L63
    L67:
        r26.setChild_effects(r28);
        goto L54
    L68:
        r7.setPanel_model(r27.getPanel_model());
        String r32 = r27.getFront_effect_id();
        Effect r33 = null;
        if (r32 == null) goto L71;
        Effect r34 = (Effect) r1.get(r32);
    L72:
        r7.setFront_effect(r34);
        String r35 = r27.getRear_effect_id();
        if (r35 == null) goto L75;
        r33 = (Effect) r1.get(r35);
    L75:
        r7.setRear_effect(r33);
        if (this.c == true) goto L78;
        h r36 = h.a;
        String r37 = this.b;
        String r38 = this.a;
        List<Effect> r39 = r27.getEffect_list();
        r36.getClass();
        h.d(r37, r38, r39);
        h.d(this.b, this.a, r27.getCollection_list());
    L78:
        return r7;
    L71:
        r34 = null;
        goto L72
    }

    public a(String r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
