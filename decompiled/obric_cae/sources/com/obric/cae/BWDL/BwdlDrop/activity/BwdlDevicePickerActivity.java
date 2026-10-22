package com.obric.cae.BWDL.BwdlDrop.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDiscoveryEngine;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;
import defpackage.b;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDevicePickerActivity extends e {
    private static final int DESTROY_ACTIVITY_TIMER = 1500;
    private static final int DISCOVERY_TIMER = 15000;
    private static final String TAG = "BwdlDevicePickerActivity";
    private BwdlDropManager mBwdlDropManager;
    private final View.OnTouchListener mCancelListener;
    private View.OnClickListener mDiscoveryClickListener;
    private BwdlDropDiscoveryEngine mDiscoveryEngine;
    private DiscoveryListener mDiscoveryListener;
    private ListView mListview;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private ScanResultAdapter mScanResultAdapter;
    private BwdlDropSession mSession;
    private Handler mUiHandler;

    public class DiscoveryListener implements BwdlDropManager.IDiscoveryListener {
        final /* synthetic */ BwdlDevicePickerActivity this$0;

        private DiscoveryListener(BwdlDevicePickerActivity r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.BWDL.BwdlDrop.BwdlDropManager.IDiscoveryListener
        public void onDiscoveryDataChanged(BWDLDiscoveryData r8) {
            CaeLog.d(BwdlDevicePickerActivity.TAG, "onDiscoveryDataChanged");
            if (r8.getBWDLDevice() == null) goto L6;
            BwdlDevicePickerActivity.access$300(this.this$0).add(r8);
            BwdlDevicePickerActivity.access$400(this.this$0).post(new AnonymousClass1(this));
            return;
        }

        public /* synthetic */ DiscoveryListener(BwdlDevicePickerActivity r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public BwdlDevicePickerActivity() {
        this.mDiscoveryClickListener = new AnonymousClass3(this);
        this.mCancelListener = new AnonymousClass4(this);
        this.mOnItemClickListener = new AnonymousClass5(this);
    }

    public static /* synthetic */ BwdlDropDiscoveryEngine access$100(BwdlDevicePickerActivity r8) {
        return r8.mDiscoveryEngine;
    }

    public static /* synthetic */ void access$200(BwdlDevicePickerActivity r8, boolean r10) {
        r8.updateDiscoveryButtonState(r10);
    }

    public static /* synthetic */ ScanResultAdapter access$300(BwdlDevicePickerActivity r8) {
        return r8.mScanResultAdapter;
    }

    public static /* synthetic */ Handler access$400(BwdlDevicePickerActivity r8) {
        return r8.mUiHandler;
    }

    public static /* synthetic */ BwdlDropManager access$500(BwdlDevicePickerActivity r8) {
        return r8.mBwdlDropManager;
    }

    public static /* synthetic */ BwdlDropSession access$600(BwdlDevicePickerActivity r8) {
        return r8.mSession;
    }

    private final void setContainerView() {
        this.mListview = (ListView) findViewById(R.id.discoveryResultList);
        ScanResultAdapter r8 = new ScanResultAdapter(this, LayoutInflater.from(this), this.mOnItemClickListener);
        this.mScanResultAdapter = r8;
        this.mListview.setAdapter(r8);
        updateDiscoveryButtonState(false);
        this.mDiscoveryEngine.discovery(true);
        this.mUiHandler.postDelayed(new AnonymousClass2(this), SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);
    }

    private final void setHeaderView() {
        OFloatingTitleBar r8 = (OFloatingTitleBar) findViewById(R.id.header_view);
        OUIFrameLayout r10 = r8.c(R.drawable.icon_leading, r8.f6623z);
        OButtonGroup r11 = r8.f6619v;
        if (r11 == null) goto L10;
        r11.k(r10, new ViewGroup.MarginLayoutParams(-2, -2));
        OButtonGroup r12 = r8.f6619v;
        if (r12 == null) goto L8;
        r12.setVisibility(0);
        findViewById(R.id.view).setOnTouchListener(this.mCancelListener);
        r10.setOnClickListener(new AnonymousClass1(this));
        return;
    L8:
        i.j("endButtonGroup");
        throw null;
    L10:
        i.j("endButtonGroup");
        throw null;
    }

    private void showToast(final String r8) {
        b.o("showToast:", r8, TAG);
        this.mUiHandler.post(new AnonymousClass6(this, r8));
        this.mUiHandler.postDelayed(new AnonymousClass7(this), 1500);
    }

    private void updateDiscoveryButtonState(boolean r8) {
        CaeLog.d(TAG, "updateDiscoveryButtonState:" + r8);
        OCardListItem r10 = (OCardListItem) findViewById(R.id.discovering);
        TextView r11 = (TextView) findViewById(R.id.textView);
        if (r8 == false) goto L5;
        r10.setClickable(true);
        r10.setContentColor(getColor(R.color.o_card_list_item_content_bg_color));
        r11.setText(R.string.discovery);
        r11.setTextColor(getColor(R.color.oui_accent_7_fg));
        r11.setOnClickListener(this.mDiscoveryClickListener);
        return;
    L5:
        r10.setClickable(false);
        r10.setContentColor(0);
        r11.setText(R.string.discovering);
        r11.setTextColor(getColor(R.color.oui_basic_text_3b));
        if (this.mBwdlDropManager.isLocationEnabled(this) == true) goto L10;
        this.mBwdlDropManager.setLocationEnabled(this, true, 0);
        showToast(getString(R.string.open_location));
        return;
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        CaeLog.d(TAG, "onCreate");
        overridePendingTransition(R.anim.o_panel_enter, R.anim.o_panel_exit);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
        Intent r10 = getIntent();
        if (r10 == null) goto L5;
        this.mSession = (BwdlDropSession) r10.getParcelableExtra(BwdlDropConstant.BWLD_DROP_SESSION);
    L5:
        BwdlDropManager r11 = BwdlDropManager.getInstance(this);
        this.mBwdlDropManager = r11;
        this.mDiscoveryEngine = r11.getDiscoveryEngine();
        this.mUiHandler = new Handler(Looper.getMainLooper());
        setContentView(R.layout.activity_device_picker);
        setHeaderView();
        setContainerView();
        DiscoveryListener r12 = new DiscoveryListener(this, null);
        this.mDiscoveryListener = r12;
        this.mBwdlDropManager.setDiscoveryListener(r12);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 512);
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CaeLog.d(TAG, "onDestroy");
        DiscoveryListener r8 = this.mDiscoveryListener;
        if (r8 == null) goto L5;
        this.mBwdlDropManager.removeDiscoveryListener(r8);
    L5:
        BwdlDropDiscoveryEngine r10 = this.mDiscoveryEngine;
        if (r10 == null) goto L8;
        r10.discovery(false);
    L8:
        this.mUiHandler.removeCallbacksAndMessages(null);
    }
}
