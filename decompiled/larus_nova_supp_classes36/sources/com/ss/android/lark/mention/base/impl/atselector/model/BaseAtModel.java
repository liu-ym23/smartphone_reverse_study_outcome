package com.ss.android.lark.mention.base.impl.atselector.model;

import android.text.TextUtils;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtSelectInitData;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.MyAIBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.UserGroupBean;
import com.ss.android.lark.mention.base.impl.atselector.d;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseAtModel extends BaseModel implements d {
    public String a;
    public d.a b;
    public final AtSelectInitData c;
    public List<BaseAtBean> d;
    public final List<BaseAtBean> e;
    public final Map<String, BaseAtBean> f;
    public String g;
    public String h;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestStatus {
        public static final int AVAILABLE = 1;
        public static final int EMPTY = 2;
        public static final int ERROR = 3;
        public static final int NOT_ARRIVE = 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final Map<String, ChatChatter> N4() {
        HashMap r0 = new HashMap();
        Iterator r1 = ((LinkedHashMap) this.f).values().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        BaseAtBean r2 = (BaseAtBean) r1.next();
        if ((r2 instanceof MyAIBean) == false) goto L4;
        Chatter r3 = new Chatter();
        r3.setId(r2.getId());
        String r4 = r2.getDisplayName();
        r3.setName(r4);
        r3.setEnName(r4);
        r3.setType(Chatter.ChatterType.AI);
        r0.put(r3.getId(), new ChatChatter(r3));
    L8:
        Map<String, BaseAtBean> r5 = this.f;
        Pattern r6 = o.a;
        if (r5.containsKey("all") == false) goto L12;
        Chatter r7 = new Chatter();
        r7.setId("all");
        String r8 = UIHelper.getString(2131891514);
        r7.setName(r8);
        r7.setEnName(r8);
        r0.put(r7.getId(), new ChatChatter(r7));
    L12:
        if (this.f.containsKey("mention_ai_knowledge") == false) goto L14;
        Chatter r9 = new Chatter();
        r9.setId("mention_ai_knowledge");
        String r10 = UIHelper.getString(2131891028);
        String r11 = arb.a.b.a0(r10);
        r9.setName(r11);
        r9.setEnName(r11);
        r0.put(r9.getId(), new ChatChatter(r9));
    L14:
        ArrayList r12 = new ArrayList();
        HashSet r13 = new HashSet();
        Iterator r14 = ((LinkedHashMap) this.f).keySet().iterator();
    L16:
        if (r14.hasNext() == false) goto L32;
        String r15 = (String) r14.next();
        BaseAtBean r16 = (BaseAtBean) ((LinkedHashMap) this.f).get(r15);
        if (r16 == null) goto L16;
        if (r16.getType() == 1) goto L16;
        if (r16.getType() == 3) goto L16;
        if (r16.getType() == 6) goto L16;
        r12.add(r15);
        if ((r16 instanceof SearchBean) == false) goto L16;
        if (((SearchBean) r16).isOutChatUser() == false) goto L16;
        r13.add(r15);
        goto L16
    L32:
        if (TextUtils.isEmpty(this.a) == true) goto L36;
        Map<String, ChatChatter> r17 = ImSdkService.d().A2(this.a, r12);
        if (CollectionUtils.isNotEmpty(r17) == false) goto L38;
        r0.putAll(r17);
    L38:
        if (r17.size() >= r12.size()) goto L49;
        ArrayList r18 = new ArrayList();
        Iterator r19 = r12.iterator();
    L41:
        if (r19.hasNext() == false) goto L45;
        String r20 = (String) r19.next();
        if (r17.containsKey(r20) == true) goto L41;
        r18.add(r20);
        goto L41
    L45:
        Iterator<Chatter> r21 = ImSdkService.d().l0(r18).values().iterator();
    L47:
        if (r21.hasNext() == false) goto L49;
        Chatter r22 = r21.next();
        ChatChatter r23 = new ChatChatter(r22);
        r0.put(r22.getId(), r23);
    L49:
        Iterator r24 = r0.values().iterator();
    L51:
        if (r24.hasNext() == false) goto L55;
        ChatChatter r25 = (ChatChatter) r24.next();
        if (r13.contains(r25.getId()) == false) goto L51;
        r25.setOutChatUser(true);
        goto L51
    L55:
        return r0;
    L36:
        r17 = new HashMap();
        goto L38
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final List<UserGroupEntity> g2() {
        ArrayList r0 = new ArrayList();
        int r1 = com.ss.android.lark.mention.base.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.setting.mention_user_group") == true) goto L5;
        return r0;
    L5:
        Iterator r2 = ((LinkedHashMap) this.f).values().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        BaseAtBean r3 = (BaseAtBean) r2.next();
        if ((r3 instanceof UserGroupBean) == false) goto L7;
        r0.add(((UserGroupBean) r3).getUserGroup());
        goto L7
    L11:
        return r0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final Map<String, BaseAtBean> b3() {
        return this.f;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final String e5() {
        return this.g;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final List<BaseAtBean> q3() {
        return this.e;
    }

    public BaseAtModel(AtSelectInitData r2) {
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new LinkedHashMap();
        this.c = r2;
    }

    public final Map<String, BaseAtBean> h(BaseAtBean r3) {
        if (this.f.containsKey(r3.getId()) == true) goto L6;
        this.f.put(r3.getId(), r3);
        k(r3, true);
    L6:
        return this.f;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.d
    public final void U0(String r2, List<BaseAtBean> r3) {
        if (TextUtils.equals(this.h, r2) == false) goto L6;
        ((ArrayList) this.e).clear();
        ((ArrayList) this.e).addAll(r3);
        return;
    }

    public final void k(BaseAtBean r5, boolean r6) {
        List<BaseAtBean> r0 = this.d;
        if (r0 == null) goto L10;
        Iterator<BaseAtBean> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        BaseAtBean r2 = r1.next();
        if (r2.getId().equals(r5.getId()) == false) goto L6;
        r2.setSelected(r6);
    L10:
        List<BaseAtBean> r3 = this.e;
        if (r3 == null) goto L18;
        Iterator r4 = ((ArrayList) r3).iterator();
    L14:
        if (r4.hasNext() == false) goto L29;
        BaseAtBean r7 = (BaseAtBean) r4.next();
        if (r7.getId().equals(r5.getId()) == false) goto L14;
        r7.setSelected(r6);
        goto L14
    L29:
        return;
    }
}
