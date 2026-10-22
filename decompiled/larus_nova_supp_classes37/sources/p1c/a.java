package p1c;

import android.content.Context;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileNavigator$openChat$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    Map<String, RecogniseSpansResult> a(List<UrlPreViewEntries> r1, String r2, String r3, Long r4);

    void b(Context r1, String r2, OfficeProfileNavigator$openChat$1 r3);

    void c(String r1, String r2, Long r3, OfficeProfileViewModel.C03842 r4);
}
