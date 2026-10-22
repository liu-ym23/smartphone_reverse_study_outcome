package p1c;

import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$acceptFriend$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$applyFriend$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$blockUser$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$deleteFriend$2$1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {
    void a(String r1, OfficeProfileModel$acceptFriend$2$1 r2);

    void b(String r1, String r2, String r3, ContactSource r4, OfficeProfileModel$applyFriend$2$1 r5);

    void c(String r1, OfficeProfileModel$deleteFriend$2$1 r2);

    void e(String r1, boolean r2, OfficeProfileModel$blockUser$2$1 r3);
}
