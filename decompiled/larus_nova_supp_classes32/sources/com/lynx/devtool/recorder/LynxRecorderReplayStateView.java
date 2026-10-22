package com.lynx.devtool.recorder;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderReplayStateView extends LinearLayout {
    public static final int DOWNLOAD_JSON_FILE = 0;
    public static final int ERROR_DOWNLOAD_FAILED = 5;
    public static final int ERROR_MISS_LYNXRECORDER_HEADER = 6;
    public static final int HANDLE_ACTION_LIST = 2;
    public static final int INVALID_JSON_FILE = 3;
    public static final int PARSING_JSON_FILE = 1;
    public static final int RECORD_ERROR_MISS_TEMPLATEJS = 4;
    private static final ArrayList<String> mState = null;
    private ProgressBar mProgress;
    private TextView mText;

    static {
        ArrayList<String> r0 = new ArrayList();
        mState = r0;
        ListProtector.add(r0, 0, "Download json file");
        ListProtector.add(r0, 1, "Parsing json file");
        ListProtector.add(r0, 2, "Handle action list");
        ListProtector.add(r0, 3, "Invalid Json File");
        ListProtector.add(r0, 4, "Record Error: Miss template.js");
        ListProtector.add(r0, 5, "LynxRecorder artifact download failed");
        ListProtector.add(r0, 6, "Miss LynxRecorder header : file://lynxrecorder?url={{{url}}}");
    }

    public void updateScreenMetrics() {
        WindowManager r0 = (WindowManager) getContext().getSystemService("window");
        Point r1 = new Point();
        r0.getDefaultDisplay().getSize(r1);
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2 != null) goto L5;
        r2 = new LinearLayout.LayoutParams(r1.x, r1.y);
    L6:
        setLayoutParams(r2);
        return;
    L5:
        r2.width = r1.x;
        r2.height = r1.y;
        goto L6
    }

    public LynxRecorderReplayStateView(Context r2) {
        super(r2);
        setId(2131384053);
        init(r2);
    }

    private int getProgress(int r2) {
        return ((r2 + 1) * 100) / (mState.size() + 1);
    }

    private void init(Context r2) {
        LayoutInflater.from(r2).inflate(2131564272, this);
        updateScreenMetrics();
        setGravity(17);
        this.mText = (TextView) findViewById(2131388387);
        this.mProgress = (ProgressBar) findViewById(2131383288);
    }

    public void setReplayState(int r3) {
        if (this.mText != null) goto L5;
        return;
    L5:
        if (this.mProgress == null) goto L13;
        if (r3 < 0) goto L10;
        ArrayList<String> r0 = mState;
        if (r3 >= r0.size()) goto L10;
        this.mText.setText((CharSequence) ListProtector.get(r0, r3));
        this.mProgress.setProgress(getProgress(r3));
        return;
    L10:
        this.mText.setText("Unknown State");
        this.mProgress.setProgress(0);
        return;
    }
}
