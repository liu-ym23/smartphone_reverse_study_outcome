package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\nR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CustomizedEffectsResponse;", "", "status_code", "", INotificationHitPoint.NoticeType.MESSAGE, "", "custom_effects", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "template_effects", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCustom_effects", "()Ljava/util/List;", "setCustom_effects", "(Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getStatus_code", "()I", "setStatus_code", "(I)V", "getTemplate_effects", "setTemplate_effects", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public class CustomizedEffectsResponse {
    private List<? extends Effect> custom_effects;
    private String message;
    private int status_code;
    private List<? extends Effect> template_effects;

    public CustomizedEffectsResponse() {
        this(0, null, null, null, 15, null);
    }

    public List<Effect> getCustom_effects() {
        return this.custom_effects;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public List<Effect> getTemplate_effects() {
        return this.template_effects;
    }

    public void setCustom_effects(List<? extends Effect> r1) {
        this.custom_effects = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public void setTemplate_effects(List<? extends Effect> r1) {
        this.template_effects = r1;
    }

    public CustomizedEffectsResponse(int r1, String r2, List<? extends Effect> r3, List<? extends Effect> r4) {
        this.status_code = r1;
        this.message = r2;
        this.custom_effects = r3;
        this.template_effects = r4;
    }

    public /* synthetic */ CustomizedEffectsResponse(int r2, String r3, List r4, List r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
