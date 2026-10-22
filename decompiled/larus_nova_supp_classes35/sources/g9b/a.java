package g9b;

import com.bytedance.lark.pb.basic.v1.ChatApplication;
import com.bytedance.lark.pb.basic.v1.ContactSummary;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.contact.base.entity.ExternalContactSummary;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements y.a<ChatApplication, com.ss.android.lark.contact.base.dto.ChatApplication> {
    public a() {
    }

    public final Object get(Object r5) {
        ChatApplication r6 = (ChatApplication) r5;
        if (r6 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.contact.base.dto.ChatApplication r0 = new com.ss.android.lark.contact.base.dto.ChatApplication();
        r0.setId(r6.id);
        r0.setApplyTime(r6.apply_time.longValue());
        r0.setChatId(r6.chat_id);
        ContactSummary r1 = r6.contact_summary;
        if (r1 == null) goto L8;
        ExternalContactSummary r2 = new ExternalContactSummary();
        r2.setAvatarKey(r1.avatar_key);
        r2.setDepartmentName(r1.department_name);
        r2.setTenantName(r1.tenant_name);
        r2.setUseId(r1.user_id);
        r2.setTenantNameStatus(r1.tenant_name_status);
        r2.setUserEnName(r1.user_en_name);
        r2.setUserName(r1.user_name);
        r2.setI18nName(r1.user_name_i18n);
        r0.setExternalContactSummary(r2);
        r0.setCertificationInfo(r6.contact_summary.certification_info);
    L8:
        r0.setExtraMessage(r6.extra_message);
        r0.setProcessedTime(r6.processed_time.longValue());
        r0.setRead(r6.is_read.booleanValue());
        r0.setStatus(com.ss.android.lark.contact.base.dto.ChatApplication.Status.forNumber(r6.status.getValue()));
        r0.setType(com.ss.android.lark.contact.base.dto.ChatApplication.Type.forNumber(r6.type.getValue()));
        return r0;
    }
}
