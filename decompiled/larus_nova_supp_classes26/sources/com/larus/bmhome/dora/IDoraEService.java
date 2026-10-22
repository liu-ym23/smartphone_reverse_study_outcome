package com.larus.bmhome.dora;

import android.view.ViewGroup;
import com.larus.avlink.gallery.VideoVH;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u001e\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/dora/IDoraEService;", "", "setExpiredText", "", "current", "Lcom/larus/im/bean/message/Message;", "getVideoVH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "shareVideoFile", "", "videoFile", "shareMediaFiles", "mediaFiles", "", "onlyShare", "", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraEService {
    void a(String r1);

    String b(Message r1);

    VideoVH c(ViewGroup r1);

    void d(List<String> r1, boolean r2);
}
