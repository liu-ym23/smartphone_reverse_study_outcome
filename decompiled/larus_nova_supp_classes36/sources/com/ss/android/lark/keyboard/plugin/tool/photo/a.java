package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import io.reactivex.Observable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    void a();

    Observable b(List r1, boolean r2, CommentKeyboardSection.handleActivityResult.1 r3);

    void c(List<? extends Photo> r1, boolean r2, boolean r3);

    void d(com.ss.android.lark.widget.photopicker.j r1);

    void e(ArrayList<String> r1, boolean r2, int r3, String r4);

    boolean f(boolean r1);

    void g(int r1);

    void h(ArrayList<File> r1);

    void i(List<Photo> r1, int r2);

    boolean j();

    void k(Photo r1, boolean r2, boolean r3, boolean r4);

    void l();

    void m(com.ss.android.lark.widget.photopicker.e r1);

    void n();

    Observable<Map<String, FrameInfo>> o(List<VideoInfo> r1);

    boolean p();
}
