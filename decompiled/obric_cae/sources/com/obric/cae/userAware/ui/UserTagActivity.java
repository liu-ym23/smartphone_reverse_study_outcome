package com.obric.cae.userAware.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class UserTagActivity extends androidx.appcompat.app.e {
    private String mClickRecords;
    private RadioGroup radioGroup;
    private Button submitButton;

    public class UserTagInfo {
        final /* synthetic */ UserTagActivity this$0;
        private String timeStamp;
        private String type;
        private String userTag;

        public UserTagInfo(UserTagActivity r8, String r10, String r11, String r12) {
            this.this$0 = r8;
            this.type = r10;
            this.timeStamp = r11;
            this.userTag = r12;
        }

        public static /* synthetic */ String access$300(UserTagInfo r8) {
            return r8.timeStamp;
        }
    }

    public UserTagActivity() {
        this.mClickRecords = "";
    }

    public static /* synthetic */ RadioGroup access$000(UserTagActivity r8) {
        return r8.radioGroup;
    }

    public static /* synthetic */ String access$102(UserTagActivity r8, String r10) {
        r8.mClickRecords = r10;
        return r10;
    }

    public static /* synthetic */ void access$200(UserTagActivity r8) {
        r8.submitRecords();
    }

    private void submitRecords() {
        Toast.makeText(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_tag_submit_records) + this.mClickRecords + UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_tag_timestamp) + UserTagInfo.access$300(new UserTagInfo(this, "UserTag", UserAwareUtil.formatDateToFullString(new Date(System.currentTimeMillis())), this.mClickRecords)), 1).show();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_user_tag);
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        Button r10 = (Button) findViewById(R.id.submit_records_button);
        this.submitButton = r10;
        r10.setOnClickListener(new AnonymousClass1(this));
    }
}
