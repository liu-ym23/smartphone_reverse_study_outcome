package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BQ\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\t¢\u0006\u0004\b)\u0010*J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R(\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000f¨\u0006+"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/QueryRewardEffectsResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "verifySign", "", "url_prefix", "Ljava/util/List;", "getUrl_prefix", "()Ljava/util/List;", "setUrl_prefix", "(Ljava/util/List;)V", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", INotificationHitPoint.NoticeType.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "has_more", "Z", "getHas_more", "()Z", "setHas_more", "(Z)V", "next_cursor", "getNext_cursor", "setNext_cursor", "Lcom/ss/ugc/effectplatform/model/Effect;", "reward_effects", "getReward_effects", "setReward_effects", "<init>", "(Ljava/util/List;ILjava/lang/String;ZILjava/util/List;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class QueryRewardEffectsResponse extends e<QueryRewardEffectsResponse> {
    private boolean has_more;
    private String message;
    private int next_cursor;
    private List<? extends Effect> reward_effects;
    private int status_code;
    private List<String> url_prefix;

    public QueryRewardEffectsResponse() {
        this(null, 0, null, false, 0, null, 63, null);
    }

    public QueryRewardEffectsResponse getResponseData() {
        return this;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1553getResponseData() {
        return getResponseData();
    }

    public String getResponseMessage() {
        return getMessage();
    }

    public int getStatusCode() {
        return getStatus_code();
    }

    public boolean verifySign() {
        List<Effect> r0 = getReward_effects();
        if (r0 == null) goto L11;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        if (b.a((Effect) r1.next()) == true) goto L6;
        return false;
    L16:
        return true;
    L11:
        return true;
    }

    public boolean getHas_more() {
        return this.has_more;
    }

    public String getMessage() {
        return this.message;
    }

    public int getNext_cursor() {
        return this.next_cursor;
    }

    public List<Effect> getReward_effects() {
        return this.reward_effects;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public void setHas_more(boolean r1) {
        this.has_more = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setNext_cursor(int r1) {
        this.next_cursor = r1;
    }

    public void setReward_effects(List<? extends Effect> r1) {
        this.reward_effects = r1;
    }

    public void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public void setUrl_prefix(List<String> r1) {
        this.url_prefix = r1;
    }

    public QueryRewardEffectsResponse(List<String> r1, int r2, String r3, boolean r4, int r5, List<? extends Effect> r6) {
        this.url_prefix = r1;
        this.status_code = r2;
        this.message = r3;
        this.has_more = r4;
        this.next_cursor = r5;
        this.reward_effects = r6;
    }

    public /* synthetic */ QueryRewardEffectsResponse(List r5, int r6, String r7, boolean r8, int r9, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = new ArrayList();
    L5:
        int r0 = 0;
        if ((r11 & 2) == 0) goto L8;
        int r13 = 0;
    L10:
        if ((r11 & 4) == 0) goto L12;
        r7 = null;
    L12:
        String r1 = r7;
        if ((r11 & 8) == 0) goto L15;
        boolean r2 = false;
    L17:
        if ((r11 & 16) != 0) goto L21;
        r0 = r9;
    L21:
        if ((r11 & 32) == 0) goto L23;
        r10 = new ArrayList();
    L23:
        List r3 = r10;
        this(r5, r13, r1, r2, r0, r3);
        return;
    L15:
        r2 = r8;
        goto L17
    L8:
        r13 = r6;
        goto L10
    }
}
